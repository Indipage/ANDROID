package com.indipage.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.databinding.FragmentMyPageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragment : BindingFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.test="https://avatars.githubusercontent.com/u/93514333?v=4"
        binding.tvMyPageProfileId.text="testtest"
        binding.tvMyPageProfileName.text="이소민박소현"
        binding.ivMyPageProfileArticle.setOnClickListener {
            findNavController().navigate(
                R.id.action_navigation_my_page_to_saved_article, bundleOf(
                )
            )
        }
        binding.ivMyPageProfileSpace.setOnClickListener {
            findNavController().navigate(
                R.id.action_navigation_my_page_to_saved_space, bundleOf(
                )
            )
        }

    }


}