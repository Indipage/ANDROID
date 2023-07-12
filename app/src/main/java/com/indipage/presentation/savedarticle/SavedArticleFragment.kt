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
import com.indipage.data.dto.response.SavedArticle
import com.indipage.databinding.FragmentSavedArticleBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class SavedArticleFragment :
    BindingFragment<FragmentSavedArticleBinding>(R.layout.fragment_saved_article) {
    // 어댑터 초기화
    private lateinit var adapter: SavedArticleAdapter

    // ViewModel 초기화
    private val viewModel by viewModels<SavedArticleViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SavedArticleAdapter()
        val articleList = listOf(
            SavedArticle(
                imageUrl = "https://avatars.githubusercontent.com/u/93514333?v=4",
                space = "Space A",
                spaceName = "Space Name 1",
                spaceComment = "Comment 1"
            ),
            SavedArticle(
                imageUrl = "https://avatars.githubusercontent.com/u/93514333?v=4",
                space = "Space B",
                spaceName = "Space Name 2",
                spaceComment = "Comment 2"
            ),
            SavedArticle(
                imageUrl = "https://avatars.githubusercontent.com/u/93514333?v=4",
                space = "Space C",
                spaceName = "Space Name 3",
                spaceComment = "Comment 3"
            )
        )
        binding.rvSavedArticle.adapter = adapter
        adapter.submitList(articleList)
        binding.coSavedArticleEmptyView.visibility = if (articleList.isEmpty()) View.VISIBLE else View.GONE
//        getCollectData()
        setNavigation()
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