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
        getArticleDetailData()
        setClickEventOnMoveToSpaceDetailTextView()
        setClickEventOnToolbar()
        setClickEventOnTicketImage()
        getTicketReceiveCheckData()
    }

    private fun setClickEventOnMoveToSpaceDetailTextView() {
        binding.tvArticleDetailMoveToPlaceDetail1.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_article_detail_to_space_detail)
        })
        binding.tvArticleDetailMoveToPlaceDetail2.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_article_detail_to_space_detail)
        })
    }

    private fun setClickEventOnToolbar() {
        binding.toolbarArticleDetail.setNavigationOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_article_detail_to_article)
        })

        binding.ivArticleDetailBookmark.setOnClickListener(View.OnClickListener {
            toast("북마크")
            binding.ivArticleDetailBookmark.isSelected = !binding.ivArticleDetailBookmark.isSelected
        })
    }

    private fun getArticleDetailData() {
        viewModel.getArticleDetail(1)

        viewModel.articleDetailData.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    val resultArticleArray = splitArticleBody(it.data.content)
                    binding.rvArticleDetailArticleBody.adapter =
                        ArticleDetailAdapter().apply { submitList(resultArticleArray) }

                    binding.tvArticleDetailAuthor.text = it.data.spaceOwner
                    binding.tvArticleDetailDate.text = it.data.createdAt
                    binding.tvArticleDetailTitle.text = it.data.title
                    binding.toolbarArticleDetail.title = it.data.spaceName
                }

                else -> {}
            }
        }.launchIn(lifecycleScope)
    }

    private fun getTicketReceiveCheckData() {
        viewModel.getTicketReceiveCheck(1)

        viewModel.ticketReceiveCheckData.observe(this) {
            if (it.hasReceivedTicket) {
                binding.ivArticleDetailTicketImage.load(it.ticket.ticketImageUrl)
                Timber.d("티켓 받음")
                toast("티켓 받음")
            } else {
                toast("티켓 안 받음")
                Timber.d("티켓 안 받음")
            }
        }

    }

    private fun setClickEventOnTicketImage() {
        binding.ivArticleDetailTicketImage.setOnClickListener(View.OnClickListener {
            snackBar(requireView(), message = { "티켓을 받았어요!" })
        })
    }


    //전체 아티클 내용 태그 별 분할
    private fun splitArticleBody(input: String): List<ArticleDetailData> {

        var currentIndex = 0
        val articleList = listOf<ArticleDetailData>().toMutableList()

        TAG_REGEX.findAll(input).forEach { matchResult ->
            //정규식을 기반으로 각각 인풋에 대한 결과를 찾는다
            val tagLessPart = input.substring(currentIndex, matchResult.range.first)
            //태그가없는 부분에서 태그의 시작점까지 섭스트링에 인덱스번호로 찾음 그 부분 모드를 태그리스에 저장
            if (tagLessPart.isNotBlank()) {
                articleList.add(ArticleDetailData(tagLessPart))
            }
            //태그리스 부분이 비어있지않다면 배열의 추가
            articleList.add(ArticleDetailData(matchResult.value))
            currentIndex = matchResult.range.last + 1
        }

        val lastTagLessPart = input.substring(currentIndex)

        if (lastTagLessPart.isNotBlank()) {
            articleList.add(ArticleDetailData(lastTagLessPart))
        }

        return articleList
    }

    companion object {
        val TAG_REGEX = "(<img>.*?</img>|<title>.*?</title>|<body>.*?</body>)".toRegex()
    }
}