package com.indipage.ui.tutorial

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.core_ui.base.BindingFragment
import com.indipage.presentation.R
import com.indipage.presentation.databinding.FragmentTutorialFifthBinding
import com.indipage.ui.MainActivity

class TutorialFifthFragment :
    BindingFragment<FragmentTutorialFifthBinding>(R.layout.fragment_tutorial_fifth) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButton()
    }

    private fun initButton() {
        binding.btnTutorialWelcome.setOnClickListener() {
            val intent =
                Intent(activity, MainActivity::class.java) //fragment라서 activity intent와는 다른 방식
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.remove(this)
                ?.commit()
        }
    }
}