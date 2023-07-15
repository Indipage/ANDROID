package com.indipage.presentation.article

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.data.dto.response.ResponseWeeklyArticleDto
import com.indipage.databinding.FragmentArticleBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.abs

@AndroidEntryPoint
class ArticleFragment : BindingFragment<FragmentArticleBinding>(R.layout.fragment_article) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.btnArticleCategoryWeekly.isSelected = true
        initArticleAdapter()
        initClickEventListeners()
    }

    private fun initArticleAdapter() {
        val dummyData: MutableList<ResponseWeeklyArticleDto> = mutableListOf(
            ResponseWeeklyArticleDto(
                "반복되는 일상 속\n나만의 아지트가\n되어주는 공간",
                "문학살롱 초고",
                "책방지기 키위",
                "4",
                "https://github.com/Indipage/ANDROID/assets/98076050/fcc88f8e-04a6-46b9-9ad4-937a4d82c8b6"
            ),
            ResponseWeeklyArticleDto(
                "반복되는 일상 속 나만의 아지트가 되어주는 공간",
                "문학살롱 초고",
                "책방지기 키위",
                "4",
                "https://github.com/Indipage/ANDROID/assets/98076050/fcc88f8e-04a6-46b9-9ad4-937a4d82c8b6"
            )
        )
        with(binding) {
            vpArticle.adapter = WeeklyArticleAdapter().apply { submitList(dummyData) }
            vpArticle.offscreenPageLimit = 2
            vpArticle.setPageTransformer { page, position ->
                page.translationX =
                    position * -resources.getDimension(R.dimen.viewpager_item_weekly_article_margin)
                page.scaleY = ((1 - abs(position)) / 4 + 0.8f)
            }
        }
    }

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