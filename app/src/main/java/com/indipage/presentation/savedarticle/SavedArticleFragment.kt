package com.indipage.presentation.savedarticle

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BindingFragment
import com.example.core_ui.view.UiState
import com.indipage.R
import com.indipage.data.dto.response.ResponseArticleDto
import com.indipage.data.dto.response.SavedArticle
import com.indipage.databinding.FragmentSavedArticleBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class SavedArticleFragment :
    BindingFragment<FragmentSavedArticleBinding>(R.layout.fragment_saved_article) {
    // 어댑터 초기화
    private lateinit var adapter: SavedArticleAdapter

    // ViewModel 초기화
    private val viewModel by viewModels<SavedArticleViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initView()
//        getCollectData()
        setNavigation()
    }
    private fun initAdapter() {
        adapter = SavedArticleAdapter()
        binding.rvSavedArticle.adapter = adapter
    }

    private fun initView() {
        viewModel.savedArticles.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    adapter.submitList(it.data)
                    binding.coSavedArticleEmptyView.visibility =
                        if (it.data.isEmpty()) View.VISIBLE else View.GONE
                    Timber.d(it.data.toString())
                }
                else -> {}
            }
        }.launchIn(lifecycleScope)

    }

    private fun setNavigation() {
        binding.tbSavedArticle.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun getCollectData() {
        viewModel.savedArticles.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    adapter.submitList(it.data)
                }
                else -> {}
            }
        }.launchIn(lifecycleScope)
    }
}