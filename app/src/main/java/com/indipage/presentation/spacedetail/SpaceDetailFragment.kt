package com.indipage.presentation.spacedetail

import android.os.Bundle
import android.view.View
import androidx.annotation.Px
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.core_ui.base.BindingFragment
import com.example.core_ui.fragment.toast
import com.example.core_ui.view.UiState
import com.indipage.R
import com.indipage.data.dto.response.CurationData
import com.indipage.data.dto.response.SpaceDetailData
import com.indipage.databinding.FragmentSpaceDetailBinding
import com.indipage.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.android.go.sopt.presentation.recycler.SpaceDetailCurationAdapter
import timber.log.Timber

@AndroidEntryPoint
class SpaceDetailFragment :
    BindingFragment<FragmentSpaceDetailBinding>(R.layout.fragment_space_detail) {

    private val viewModel by viewModels<SpaceDetailViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spaceId = requireArguments().getInt("spaceId")
        Timber.tag("SakSpace").d("$spaceId")
        binding.vm=viewModel
        initView(spaceId)

    }

    private fun initView(spaceId: Int) {
        getSpaceDetail()
        getCurationData()
        viewModel.setSpaceId(spaceId)
        initBookmarkButton(spaceId)
        initSpaceArticle(spaceId)
    }

    /** 북마크 버튼 초기화
     * 1. getBookmarked : 북마크 여부를 서버에서 get
     * 2. bookMarked observe scope 실행
     * 3.   북마크 == true일 시
     *          아이콘 selected 모양
     *          클릭 리스너 -> deleteBookmarked
     * 4.   북마크 == false일 시
     *          아이콘 !selected 모양
     *          클릭 리스너 -> postBookmarked */

    private fun initBookmarkButton(spaceId: Int) = with(binding) {
        viewModel.getBookmarked(spaceId)
        viewModel.bookMarked.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    when (it.data.bookmarked) {
                        true -> {
                            ibBookmarkIcon.isSelected = true
                            ibBookmarkIcon.setOnClickListener {
                                Timber.d("터치 됏당~!") // 누르면 조르기
                                viewModel.deleteBookMarked(1)
                            }
                        }

                        false -> {
                            ibBookmarkIcon.isSelected = false
                            ibBookmarkIcon.setOnClickListener { // 누르면 조르기
                                viewModel.postBookMarked(1)
                                Timber.d("터치 됏당~!")
                            }
                        }
                    }
                }

                else -> {}
            }
        }.launchIn(lifecycleScope)
    }

    /** 공간 상세페이지 초기화
     * 1. spaceDetailData observe scope 실행
     * 2.   성공 시 initTagAdapter 실행 */
    private fun getSpaceDetail() {
        viewModel.spaceDetailData.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    initTagAdapter(it.data)
                }

                else -> {}
            }
        }.launchIn(lifecycleScope)
    }

    /**initTagAdapter
     * 1. binding 전달
     * 2. 추천 서가 recycler view LayoutManager 설정
     * 3. recycler view adapter*/
    private fun initTagAdapter(item: SpaceDetailData) = with(binding) {
        spaceDetail = item
        rvSpaceDetailTag.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvSpaceDetailTag.adapter = SpaceDetailTagAdapter(item.tagList)
    }

    /**1. 서버에서 curationData 받아오기
     * */
    private fun getCurationData() {
        viewModel.curationData.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    initCurationAdapter2(it.data)
                }

                else -> {}
            }
        }.launchIn(lifecycleScope)
    }

    /**initCurationAdapter */
    private fun initCurationAdapter2(item: List<CurationData>) {
        with(binding) {
            vpCuration.apply {
                adapter = SpaceDetailCurationAdapter().apply { submitList(item) }
                offscreenPageLimit = 1
                post { setCurrentItem(item.size / 2, true) }
                registerOnPageChangeCallback(
                    object : ViewPager2.OnPageChangeCallback() {
                        override fun onPageSelected(position: Int) {
                            super.onPageSelected(position)
                            curation = item[position]
                        }

                        override fun onPageScrolled(
                            position: Int,
                            positionOffset: Float,
                            @Px positionOffsetPixels: Int
                        ) {
                        }
                    }
                )
            }
        }
        setDeviceOffset()
    }

    private fun setDeviceOffset() {
        val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
        val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)
        val screenWidth = resources.displayMetrics.widthPixels
        val offset = screenWidth - pageWidth - pageMargin
        setPageTransformer(offset)
    }

    private fun setPageTransformer(offset: Float) = with(binding) {
        vpCuration.setPageTransformer { page, position ->

            page.translationX = position * -offset
            val absPos = Math.abs(position)
            var alphaByPosition = 1 - absPos
            if (alphaByPosition < 0.5) {
                alphaByPosition = 0.5f
            }
            page.alpha = alphaByPosition
            ivPurpleFrame.visibility = if (position % 1 == 0.0f) View.VISIBLE else View.GONE
        }
    }

    private fun initSpaceArticle(spaceId: Int) {
        viewModel.getSpaceArticle(spaceId)
        viewModel.spaceArticle.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    binding.spaceArticle = it.data
                    binding.clSpaceArticle.visibility = View.VISIBLE
                    initSpaceArticleButton()
                }
                else -> {
                    initFollowButton(spaceId)
                }
            }
        }.launchIn(lifecycleScope)
    }

    private fun initFollowButton(spaceId: Int) = with(binding) {
        binding.clFollow.visibility = View.VISIBLE
        viewModel.follow.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    Timber.d("{$it} 조르기 버튼 UI 초기화")
                    if (it.data.isFollowed) {
                        btnFollow.text = "조르기 완료"
                        btnFollow.isSelected = true
                    } else {
                        btnFollow.setOnClickListener { // 누르면 조르기
                            viewModel.postFollow(spaceId)
                            toast("아티클이 발행되면 알려드릴게요!")
                        }

                    }
                }

                else -> {}
            }
        }.launchIn(lifecycleScope)
    }

    private fun initSpaceArticleButton() {
            viewModel.openArticleDetail.observe(viewLifecycleOwner, EventObserver {
                moveToSpaceArticle(it.toLong())
            })
    }

    private fun moveToSpaceArticle(articleId:Long) {
        findNavController().navigate(
            R.id.action_navigation_space_detail_to_navigation_article_detail,
            bundleOf("articleId" to articleId)
        )
    }
}