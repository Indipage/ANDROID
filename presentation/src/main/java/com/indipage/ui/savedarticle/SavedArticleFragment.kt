package com.indipage.ui.savedarticle

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BindingFragment
import com.example.core_ui.view.UiState
import com.indipage.presentation.R
import com.indipage.presentation.databinding.FragmentSavedArticleBinding
import com.indipage.ui.signin.SignInViewModel
import com.indipage.util.EventObserver
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
    private val parentViewModel by activityViewModels<SignInViewModel>()
    override fun onStart() {
        super.onStart()
        parentViewModel.getUser()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initView()
        setNavigation()
        viewModel.getSavedArticles()
        moveToArticleDetail()
    }

    private fun moveToArticleDetail() {
        viewModel.openArticleEvent.observe(viewLifecycleOwner, EventObserver {
            Timber.d("test $it")
            findNavController().navigate(
                R.id.action_navigation_saved_article_to_navigation_article_detail, bundleOf(
                    "articleId" to it
                )
            )
        })
    }

    private fun initAdapter() {
        adapter = SavedArticleAdapter(onMoveToArticleDetailClick = { article, position ->
            Timber.tag("articleTest").d("${article.id}")
            viewModel.openArticleDetail(article.id.toLong())
        })
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

}