package com.indipage.presentation.qr

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.databinding.FragmentQrSuccessBinding

class QrSuccessFragment : BindingFragment<FragmentQrSuccessBinding>(R.layout.fragment_qr_success) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvQrSuccessTitle.setOnClickListener {
            findNavController().navigateUp() }
    }
}