package com.indipage.presentation.profile

import android.os.Bundle
import android.view.View
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.databinding.FragmentMyPageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragment : BindingFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}