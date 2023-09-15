package com.indipage.ui.tutorial

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.core_ui.base.BindingActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.indipage.presentation.R
import com.indipage.presentation.databinding.ActivityTutorialBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TutorialActivity : BindingActivity<ActivityTutorialBinding>(R.layout.activity_tutorial) {

    private lateinit var tutorialAdapter: TutorialAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
    }

    override fun initView() {
        initAdapter()
    }

    private fun initAdapter() {
        val tutorialIndicator = binding.vpTutorialIndicator

        tutorialAdapter = TutorialAdapter(this)
        viewPager = binding.vpTutorial
        viewPager.adapter = tutorialAdapter

        TabLayoutMediator(tutorialIndicator, viewPager) { tab, position ->

        }.attach()
    }
}