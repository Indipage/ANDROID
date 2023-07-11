package com.indipage.presentation.spacedetail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.annotation.Px
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.data.dto.response.MockBookData
import com.indipage.data.dto.response.MockCurationData
import com.indipage.databinding.FragmentSpaceDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import org.android.go.sopt.presentation.recycler.SpaceDetailCurationAdapter
import timber.log.Timber
import kotlin.math.abs

@AndroidEntryPoint
class SpaceDetailFragment :
    BindingFragment<FragmentSpaceDetailBinding>(R.layout.fragment_space_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSpaceDetailTag.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvSpaceDetailTag.adapter = SpaceDetailTagAdapter(listOf("안녕", "만나서", "반가워"))
        val tmpItem =
            listOf(
                MockCurationData(
                    comment = "아주 재밌어요아주 재밌어요아주 재밌어요아주 재밌어요아주 재밌어요아주 재밌어요아주 재밌어요",
                    MockBookData(
                        id = 1,
                        title = "이삭",
                        imageUrl = "https://avatars.githubusercontent.com/u/93514333?v=4"
                    )
                ), MockCurationData(
                    comment = "대전 성심당 부근 여행자에게 영감을 주는 여행 서점 겸 카페다. 서점은 2층에 있으며, 1층은 '도시여행자' 카페로 운영한다. 전시와 북토크, 심야책방을 정기적으로 연다. 책방지기는 이 공간에서 삶의 다양한 방향성을 제시하고자 한다. 도시문화 콘텐츠 기획을 겸하고 있다.",
                    MockBookData(
                        id = 2,
                        title = "박소현",
                        imageUrl =
                        "https://avatars.githubusercontent.com/u/98076050?v=4"
                    )
                ), MockCurationData(
                    comment = "꿀잼이당",
                    MockBookData(
                        id = 3,
                        title = "이소민",
                        imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4"
                    )
                )
            )
        initCurationAdapter(tmpItem)
        initButton()
    }

    private fun initButton() = with(binding) {
        btnFollow.setOnClickListener {
            btnFollow.setBackgroundColor(Color.parseColor("#FFAA59FC"))
            btnFollow.text = "조르기 완료"
        }
    }

    private fun initCurationAdapter(item: List<MockCurationData>) {
        with(binding) {
            vpCuration.adapter = SpaceDetailCurationAdapter().apply {
                submitList(item)
            }
            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
            val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)
            val screenWidth = resources.displayMetrics.widthPixels
            val offset = screenWidth - pageWidth - pageMargin
            vpCuration.offscreenPageLimit = 3
            vpCuration.setPageTransformer { page, position ->
                page.translationX = position * -offset
                if (position == 0f) {
                    page.alpha = 1f
                    ivPurpleFrame.visibility = View.VISIBLE
                    Timber.d("$position, $page, 과학 1")
                } else {
                    if (position == 1f || position == 2f) {
                        ivPurpleFrame.visibility = View.VISIBLE
                    } else {
                        ivPurpleFrame.visibility = View.GONE
                    }
                    var normalizedposition = abs(1 - abs(position))
                    if (normalizedposition < 0.5) {
                        normalizedposition = 0.5f
                    }
                    page.alpha = normalizedposition
                    Timber.d("$position, $page, 과학 2")
                }
            }
            vpCuration.post {
                vpCuration.setCurrentItem(1, true)
            }
            vpCuration.registerOnPageChangeCallback(
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
}