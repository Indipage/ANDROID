package com.indipage.presentation.ticket

import android.os.Bundle
import android.view.View
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.databinding.FragmentTicketBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TicketFragment : BindingFragment<FragmentTicketBinding>(R.layout.fragment_ticket) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}