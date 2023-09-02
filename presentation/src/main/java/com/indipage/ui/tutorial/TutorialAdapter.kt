package com.indipage.ui.tutorial

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TutorialAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        val index: Int = position
        return if (index == 0) TutorialFirstFragment()
        else if (index == 1) TutorialSecondFragment()
        else if (index == 2) TutorialThirdFragment()
        else if (index == 3) TutorialFourthFragment()
        else TutorialFifthFragment()
    }

}
