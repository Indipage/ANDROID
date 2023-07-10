package com.indipage.presentation.savedarticle

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.databinding.FragmentSavedArticleBinding
import com.indipage.presentation.MainViewModel
import com.indipage.presentation.TestRecyclerviewPagingAdapter
import com.indipage.util.pagingSubmitData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedArticleFragment :
    BindingFragment<FragmentSavedArticleBinding>(R.layout.fragment_saved_article) {
    // 어댑터 초기화
    private val adapter = SavedArticleAdapter()

    // ViewModel 초기화
    private val viewModel by viewModels<SavedArticleViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSavedArticle()
    }

    private fun initSavedArticle() {
        binding.rvSavedArticle.adapter = adapter.apply {
            pagingSubmitData(viewLifecycleOwner, viewModel.getRecyclerviewTest(), adapter)
        }
    }
}