package com.indipage.presentation.spacedetail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.annotation.Px
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.core_ui.base.BindingFragment
import com.example.core_ui.view.UiState
import com.indipage.R
import com.indipage.data.dto.response.CurationData
import com.indipage.data.dto.response.SpaceDetailData
import com.indipage.databinding.FragmentSpaceDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.android.go.sopt.presentation.recycler.SpaceDetailCurationAdapter
import timber.log.Timber
import kotlin.math.abs

@AndroidEntryPoint
class SpaceDetailFragment :
    BindingFragment<FragmentSpaceDetailBinding>(R.layout.fragment_space_detail) {

    private val viewModel by viewModels<SpaceDetailViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCuration()
        initButton()
        getCurationData()
        getSpaceDetail()
    }

    private fun getSpaceDetail() {
        viewModel.spaceDetailData.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    Timber.d("$it.data 실험")
                    initTagAdapter(it.data)
                }

                else -> {}
            }
        }.launchIn(lifecycleScope)
    }

    private fun getCurationData() {
        viewModel.curationData.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    Timber.d("$it 실험")
                    initCurationAdapter(it.data)
                }

                else -> {}
            }
        }.launchIn(lifecycleScope)
    }

    private fun initButton() = with(binding) {
        btnFollow.setOnClickListener {
            btnFollow.setBackgroundColor(Color.parseColor("#FFAA59FC"))
            btnFollow.text = "조르기 완료"
        }

        ivBookmarkIcon.setOnClickListener(){
            ivBookmarkIcon.isSelected = !ivBookmarkIcon.isSelected
        }
    }

    private fun initTagAdapter(item: SpaceDetailData) = with(binding) {
        spaceDetail = item

        binding.rvSpaceDetailTag.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvSpaceDetailTag.adapter = SpaceDetailTagAdapter(listOf("안녕", "만나서", "반가워"))
    }

    private fun initCurationAdapter(item: List<CurationData>) {
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