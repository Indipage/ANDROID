package com.indipage.ui.article

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BindingFragment
import com.example.core_ui.view.UiState
import com.indipage.presentation.R
import com.indipage.presentation.databinding.FragmentArticleBinding
import com.indipage.util.EventObserver
import com.indipage.util.WeeklyArticle.KEY_ARTICLE_ID
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
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
        viewModel.getArticleWeekly()
        viewModel.getArticleSlide()
        setUpArticleData()
    }

    private fun setUpArticleData() {
        observeArticleWeekly()
        observeArticleSlide()
    }

    private fun observeArticleWeekly() {
        viewModel.articleWeeklyData.observe(viewLifecycleOwner) { article ->
            binding.btnArticleCategoryAll.setOnClickListener {
                viewModel.openArticleAll(article)
            }
            with(binding) {
                vpArticle.adapter =
                    WeeklyArticleAdapter(
                        onMoveToArticleDetailClick = { it, position ->
                            viewModel.openArticleDetail(it)
                        }
                    ).apply { submitList(listOf(article, article)) }
                vpArticle.offscreenPageLimit = 2
                vpArticle.setPageTransformer { page, position ->
                    page.translationX =
                        position * -resources.getDimension(R.dimen.viewpager_item_weekly_article_margin)
                    page.scaleY = ((1 - abs(position)) / 5 + 0.8f)
                    page.scaleX = ((1 - abs(position)) / 5 + 0.8f)
                }
                articleWeekly = article
                executePendingBindings()
                motion(article.id.toLong())
            }

        }

        viewModel.openArticleDetail.observe(viewLifecycleOwner, EventObserver {
            openArticleDetail(it.id.toLong())
        })

        viewModel.openArticleAll.observe(viewLifecycleOwner, EventObserver {
            openArticleAll()
        })
    }

    private fun observeArticleSlide() {
        viewModel.articleSlideData.observe(viewLifecycleOwner) {
            with(binding) {
                if (it.hasSlide) {
                    vpArticle.isVisible = true
                    layoutWeekly.isVisible = false
                } else {
                    layoutWeekly.isVisible = true
                    vpArticle.isVisible = false
                }
            }
        }

        viewModel.putArticleSlide.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    when (it.data) {
                        200 -> {
                            Timber.d("슬라이드 함")
                        }
                        400 -> {
                            Timber.d("잘못 된 요청")
                        }
                    }
                }
                else -> {}
            }
        }.launchIn(lifecycleScope)

    }

    private fun motion(articleId: Long) {
        binding.layoutCardAnimation.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(
                motionLayout: MotionLayout?, startId: Int, endId: Int
            ) {
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?, startId: Int, endId: Int, progress: Float
            ) {

            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                viewModel.putArticleSlide()
                binding.layoutWeekly.isVisible = false
                openArticleDetail(articleId)
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?, triggerId: Int, positive: Boolean, progress: Float
            ) {
            }
        })
    }

    private fun openArticleDetail(articleId: Long) {
        findNavController().navigate(
            R.id.action_article_to_article_detail, bundleOf(KEY_ARTICLE_ID to articleId)
        )
    }

    private fun openArticleAll() {
        findNavController().navigate(R.id.action_article_to_article_all)
    }
}