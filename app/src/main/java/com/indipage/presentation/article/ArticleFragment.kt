package com.indipage.presentation.article

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.fragment.app.viewModels
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.databinding.FragmentArticleBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.abs

@AndroidEntryPoint
class ArticleFragment : BindingFragment<FragmentArticleBinding>(R.layout.fragment_article) {

    private val viewModel by viewModels<ArticleViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.btnArticleCategoryWeekly.isSelected = true
        initClickEventListeners()
        setUpArticleData()
    }

    private fun setUpArticleData() {
        observeArticleWeekly()
    }

    private fun observeArticleWeekly() {
        viewModel.articleWeeklyData.observe(viewLifecycleOwner) {
            with(binding) {
                vpArticle.adapter = WeeklyArticleAdapter().apply { submitList(listOf(it, it)) }
                vpArticle.offscreenPageLimit = 2
                vpArticle.setPageTransformer { page, position ->
                    page.translationX =
                        position * -resources.getDimension(R.dimen.viewpager_item_weekly_article_margin)
                    page.scaleY = ((1 - abs(position)) / 4 + 0.8f)
                }
                articleWeekly = it
                executePendingBindings()
            }
        }

    }



    private fun setClickEventOnCategoryButton() {
        binding.btnArticleCategoryWeekly.setOnClickListener(View.OnClickListener {
            binding.btnArticleCategoryWeekly.isSelected =
                !binding.btnArticleCategoryWeekly.isSelected
            binding.btnArticleCategoryAll.isSelected = !binding.btnArticleCategoryAll.isSelected
        })
        binding.btnArticleCategoryAll.setOnClickListener(View.OnClickListener {
            binding.btnArticleCategoryAll.isSelected = !binding.btnArticleCategoryAll.isSelected
            binding.btnArticleCategoryWeekly.isSelected =
                !binding.btnArticleCategoryWeekly.isSelected
            findNavController().navigate(R.id.action_article_to_article_all)

        })

    private fun initClickEventListeners() {
        with(binding) {
            ivArticleCardPacked.setOnClickListener {
                layoutCardAnimation.isVisible = false
                vpArticle.isVisible = true
            }
            btnArticleCategoryWeekly.setOnClickListener {
                btnArticleCategoryWeekly.isSelected = !btnArticleCategoryWeekly.isSelected
                btnArticleCategoryAll.isSelected = !btnArticleCategoryAll.isSelected
            }
            btnArticleCategoryAll.setOnClickListener {
                btnArticleCategoryAll.isSelected = !btnArticleCategoryAll.isSelected
                btnArticleCategoryWeekly.isSelected = !btnArticleCategoryWeekly.isSelected
            }
        }
    }
}