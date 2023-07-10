package com.indipage.presentation.ticket

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.databinding.FragmentTicketBinding
import com.indipage.presentation.qr.QrScanActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TicketFragment : BindingFragment<FragmentTicketBinding>(R.layout.fragment_ticket) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvTicket.setOnClickListener {
            Intent(activity, QrScanActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(this)
            }
        }
    }
}