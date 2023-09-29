package com.indipage.ui.articleall

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BindingFragment
import com.indipage.presentation.R
import com.indipage.presentation.databinding.FragmentArticleAllBinding
import com.indipage.ui.signin.SignInViewModel
import com.indipage.util.EventObserver
import com.indipage.util.WeeklyArticle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleAllFragment :
    BindingFragment<FragmentArticleAllBinding>(R.layout.fragment_article_all) {

    private val viewModel by viewModels<ArticleAllViewModel>()
    private val mainViewModel by activityViewModels<SignInViewModel>()
    override fun onStart() {
        super.onStart()
        mainViewModel.getUser()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.btnArticleAllCategoryAll.isSelected = true
        initClickEventListeners()
        observeArticleAll()
        viewModel.getArticleAll()
    }

    private fun observeArticleAll() {
        viewModel.articleAllData.observe(viewLifecycleOwner) {
            binding.rvArticle.adapter = ArticleAllAdapter(onMoveToArticleDetailClick = { it, position->
                viewModel.openArticleDetail(it)
            }).apply {
                submitList(it)
            }
            binding.progressbarArticleAll.isVisible = false
        }

        viewModel.openArticleDetail.observe(viewLifecycleOwner, EventObserver {
            openArticleDetail(it.id.toLong())
        })

    }

    private fun initClickEventListeners() {
        with(binding) {
            btnArticleAllCategoryWeekly.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun openArticleDetail(articleId: Long) {
        findNavController().navigate(
            R.id.action_article_all_to_article_detail,
            bundleOf(WeeklyArticle.KEY_ARTICLE_ID to articleId)
        )
    }
}