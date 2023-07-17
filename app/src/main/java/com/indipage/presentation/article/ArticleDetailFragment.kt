package com.indipage.presentation.article

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.core_ui.base.BindingFragment
import com.example.core_ui.fragment.snackBar
import com.example.core_ui.fragment.toast
import com.example.core_ui.view.UiState
import com.indipage.R
import com.indipage.databinding.FragmentArticleDetailBinding
import com.indipage.util.ArticleDetailTag.TAG_REGEX
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber


@AndroidEntryPoint
class ArticleDetailFragment :
    BindingFragment<FragmentArticleDetailBinding>(R.layout.fragment_article_detail) {

    private val viewModel by viewModels<ArticleDetailViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        getData()
        setUpArticleDetail()
        initClickEventListeners()
    }

    private fun getData() {
        viewModel.getArticleDetail(1)
        viewModel.getTicketReceiveCheck(1)
        viewModel.getBookMark(4)
    }

    private fun setUpArticleDetail() {
        observeArticle()
        observeTicket()
        observeBookmark()
    }

    private fun observeArticle() {
        viewModel.articleDetailData
            .flowWithLifecycle(lifecycle)
            .onEach { uiState ->
                when (uiState) {
                    is UiState.Success -> {
                        val resultArticleArray = splitArticleContent(uiState.data.content)
                        with(binding) {
                            rvArticleDetailArticleBody.adapter =
                                ArticleDetailAdapter().apply { submitList(resultArticleArray) }

                            tvArticleDetailAuthor.text = uiState.data.spaceOwner
                            tvArticleDetailDate.text = uiState.data.createdAt
                            tvArticleDetailTitle.text = uiState.data.title
                            toolbarArticleDetail.title = uiState.data.spaceName
                        }
                    }
                    else -> {}
                }
            }.launchIn(lifecycleScope)
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
            if (it.hasReceivedTicket) {
                binding.ivArticleDetailTicketImage.load(it.ticket.ticketImageUrl)
                Timber.d("티켓 받음")
                toast("티켓 받음")
            } else {
                Timber.d("티켓 안 받음")
                toast("티켓 안 받음")
            }
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
                binding.ivArticleDetailBookmark.setImageResource(R.drawable.ic_article_detail_bookmark_on)
                Timber.d("북마크 됨")
            } else {
                binding.ivArticleDetailBookmark.setImageResource(R.drawable.ic_article_detail_bookmark_off)
                Timber.d("북마크 안됨")
                binding.ivArticleDetailBookmark.setOnClickListener {
                    viewModel.postBookMark(4)
                    binding.ivArticleDetailBookmark.setImageResource(R.drawable.ic_article_detail_bookmark_on)
                }
            }
        }

    }

    private fun initClickEventListeners() {
        with(binding) {
            tvArticleDetailMoveToPlaceDetail1.setOnClickListener {
                findNavController().navigate(R.id.action_article_detail_to_space_detail)
            }
            tvArticleDetailMoveToPlaceDetail2.setOnClickListener {
                findNavController().navigate(R.id.action_article_detail_to_space_detail)
            }
            ivArticleDetailTicketImage.setOnClickListener {
                viewModel.postTicketReceive(1)
            }
            toolbarArticleDetail.setNavigationOnClickListener {
                findNavController().navigate(R.id.action_article_detail_to_article)
            }
        }
    }

    //전체 아티클 내용 태그 별 분할
    private fun splitArticleContent(input: String): List<ArticleDetailData> {
        var currentIndex = 0
        val articleList = mutableListOf<ArticleDetailData>()

        TAG_REGEX.findAll(input).forEach { matchResult ->

            val tagLessPart = input.substring(currentIndex, matchResult.range.first)

            if (tagLessPart.isNotBlank()) {
                articleList.add(ArticleDetailData(tagLessPart))
            }

            articleList.add(ArticleDetailData(matchResult.value))
            currentIndex = matchResult.range.last + 1
        }

        val lastTagLessPart = input.substring(currentIndex)
        if (lastTagLessPart.isNotBlank()) {
            articleList.add(ArticleDetailData(lastTagLessPart))
        }

        return articleList
    }
}