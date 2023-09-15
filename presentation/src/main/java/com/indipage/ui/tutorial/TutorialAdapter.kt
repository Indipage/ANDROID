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
        return when (position) {
            0 -> TutorialFirstFragment()
            1 -> TutorialSecondFragment()
            2 -> TutorialThirdFragment()
            3 -> TutorialFourthFragment()
            else -> TutorialFifthFragment()
        }
    }

}
