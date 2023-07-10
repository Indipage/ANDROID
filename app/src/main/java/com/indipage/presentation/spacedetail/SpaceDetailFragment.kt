package com.indipage.presentation.spacedetail

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.databinding.FragmentSpaceDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpaceDetailFragment :
    BindingFragment<FragmentSpaceDetailBinding>(R.layout.fragment_space_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tagAdapter = SpaceDetailTagAdapter()
        binding.rvSpaceDetailTag.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvSpaceDetailTag.adapter = tagAdapter
    }
}