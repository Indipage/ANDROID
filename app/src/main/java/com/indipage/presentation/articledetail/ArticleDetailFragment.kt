package com.indipage.presentation.articledetail

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.example.core_ui.base.BindingFragment
import com.example.core_ui.fragment.snackBar
import com.example.core_ui.view.UiState
import com.indipage.R
import com.indipage.databinding.FragmentArticleDetailBinding
import com.indipage.util.ArticleDetailTag.TAG_REGEX
import com.indipage.util.EventObserver
import com.indipage.util.WeeklyArticle.KEY_ARTICLE_ID
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber


@AndroidEntryPoint
class ArticleDetailFragment :
    BindingFragment<FragmentArticleDetailBinding>(R.layout.fragment_article_detail) {

    private val viewModel by viewModels<ArticleDetailViewModel>()
    private var spaceId: Long? = null
    private lateinit var headAdapter: ArticleDetailHeadAdapter
    private lateinit var contentAdapter: ArticleDetailAdapter
    private lateinit var bottomAdapter: ArticleDetailBottomAdapter
    private lateinit var bottomTicketAdapter: ArticleDetailBottomTicketAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        getData()
        setUpArticleDetail()
        initClickEventListeners()
        concatAdapter()
    }

    private fun concatAdapter() {
        headAdapter = ArticleDetailHeadAdapter(viewModel)
        contentAdapter = ArticleDetailAdapter()
        bottomAdapter = ArticleDetailBottomAdapter(viewModel)
        bottomTicketAdapter = ArticleDetailBottomTicketAdapter(viewModel)
        binding.rvArticleDetailArticleBody.adapter =
            ConcatAdapter(headAdapter, contentAdapter, bottomAdapter, bottomTicketAdapter)

    }

    private fun getData() {
        requireArguments().getLong(KEY_ARTICLE_ID).let {
            viewModel.getArticleDetail(it)
            viewModel.getBookMark(it)
        }
    }

    private fun setUpArticleDetail() {
        observeArticle()
        observeTicket()
        observeBookmark()
    }

    private fun observeArticle() {
        viewModel.articleDetailData.flowWithLifecycle(lifecycle).onEach { uiState ->
            when (uiState) {
                is UiState.Success -> {
                    binding.progressArticleDetail.isVisible = false
                    val resultArticleArray =
                        splitArticleContent(uiState.data.content, uiState.data.spaceId.toLong())
                    with(binding) {
                        articleDetail = uiState.data
                        executePendingBindings()
                        headAdapter.apply { submitList(listOf(uiState.data)) }
                        contentAdapter.apply { submitList(resultArticleArray) }
                        bottomAdapter.apply { submitList(listOf(uiState.data)) }
                        spaceId = uiState.data.spaceId.toLong()
                        spaceId?.let { viewModel.getTicketReceiveCheck(it) }
                    }
                }
                else -> {}
            }
        }.launchIn(lifecycleScope)

        viewModel.openSpaceDetail.observe(viewLifecycleOwner, EventObserver {
            openSpaceDetail(it.spaceId.toLong())
        })
    }

    private fun observeTicket() {
        viewModel.postTicketReceive.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    when (it.data) {
                        201 -> {
                            snackBar(requireView(), message = { "티켓을 받았어요!" })
                        }
                        409 -> {
                            snackBar(requireView(), message = { "이미 티켓을 받았어요!" })
                        }
                    }
                }
                else -> {}
            }
        }.launchIn(lifecycleScope)

        viewModel.ticketReceiveCheckData.observe(viewLifecycleOwner) {
            bottomTicketAdapter.apply { submitList(listOf(it)) }
        }
    }

    private fun observeBookmark() {
        viewModel.postArticleBookmark.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    when (it.data) {
                        201 -> {
                            snackBar(requireView(), message = { "북마크 성공" })
                        }
                        404 -> {
                            Timber.d("존재하지 않는 아티클")
                        }
                    }
                }
                else -> {}
            }
        }.launchIn(lifecycleScope)

        viewModel.articleBookmarkData.observe(viewLifecycleOwner) {
            if (it.bookmarked) {
                binding.ivArticleDetailBookmark.isSelected = true
                Timber.d("북마크 됨")
            } else {
                binding.ivArticleDetailBookmark.isSelected = false
                Timber.d("북마크 안됨")
            }
        }

        viewModel.deleteArticleBookmark.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    when (it.data) {
                        200 -> {
                            snackBar(requireView(), message = { "북마크 취소" })
                        }
                        404 -> {
                            Timber.d("존재하지 않는 아티클")
                        }
                    }
                }
                else -> {}
            }
        }.launchIn(lifecycleScope)

    }

    private fun initClickEventListeners() {
        with(binding) {
            toolbarArticleDetail.setNavigationOnClickListener {
                findNavController().navigateUp()
            }
            ivArticleDetailBookmark.setOnClickListener {
                requireArguments().getLong(KEY_ARTICLE_ID).let {
                    if (ivArticleDetailBookmark.isSelected) {
                        viewModel.deleteBookMark(it)
                        binding.ivArticleDetailBookmark.isSelected = false
                    } else {
                        viewModel.postBookMark(it)
                        binding.ivArticleDetailBookmark.isSelected = true
                    }
                }
            }
        }
    }

    //전체 아티클 내용 태그 별 분할
    private fun splitArticleContent(input: String, spaceId: Long): List<ArticleDetailData> {
        var currentIndex = 0
        val articleList = mutableListOf<ArticleDetailData>()

        TAG_REGEX.findAll(input).forEach { matchResult ->

            val tagLessPart = input.substring(currentIndex, matchResult.range.first)

            if (tagLessPart.isNotBlank()) {
                articleList.add(ArticleDetailData(tagLessPart, spaceId))
            }

            articleList.add(ArticleDetailData(matchResult.value, spaceId))
            currentIndex = matchResult.range.last + 1
        }

        val lastTagLessPart = input.substring(currentIndex)
        if (lastTagLessPart.isNotBlank()) {
            articleList.add(ArticleDetailData(lastTagLessPart, spaceId))
        }

        return articleList
    }

    private fun openSpaceDetail(spaceId: Long) {
        findNavController().navigate(
            R.id.action_article_detail_to_space_detail, bundleOf("spaceId" to spaceId.toInt())
        )
    }
}