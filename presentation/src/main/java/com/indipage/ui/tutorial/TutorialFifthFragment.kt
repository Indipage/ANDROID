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
            startActivity(Intent(requireActivity(), MainActivity::class.java))
            requireActivity().finish()
        }
    }
}