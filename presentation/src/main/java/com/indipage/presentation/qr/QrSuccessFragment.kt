package com.indipage.presentation.qr

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BindingFragment
import com.indipage.presentation.R
import com.indipage.presentation.databinding.FragmentQrSuccessBinding

class QrSuccessFragment : BindingFragment<FragmentQrSuccessBinding>(R.layout.fragment_qr_success) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardImageUrl = requireArguments().getString("cardImageUrl")
        binding.url=cardImageUrl
        binding.btnQrSuccessMoveCard.setOnClickListener {
            findNavController().navigate(
                R.id.action_navigation_qr_success_to_navigation_card,
                bundleOf()
            )
        }
    }
}