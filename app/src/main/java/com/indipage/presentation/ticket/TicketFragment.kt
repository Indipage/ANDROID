package com.indipage.presentation.ticket

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.databinding.FragmentTicketBinding
import com.indipage.presentation.qr.QrScanActivity
import com.indipage.presentation.savedspace.SavedSpaceViewModel
import com.indipage.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TicketFragment : BindingFragment<FragmentTicketBinding>(R.layout.fragment_ticket) {

    private lateinit var adapter: TicketAdapter

    private val viewModel by viewModels<TicketViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TicketAdapter()
        val spaceList = listOf(
            "https://avatars.githubusercontent.com/u/93514333?v=4",
            "https://avatars.githubusercontent.com/u/93514333?v=4",
            "https://avatars.githubusercontent.com/u/93514333?v=4",

            )
        binding.rvTicketTicket.adapter = adapter
        val itemTouchHelper = ItemTouchHelper(TicketItemHelper(viewModel))
        itemTouchHelper.attachToRecyclerView(binding.rvTicketTicket)
        adapter.submitList(spaceList)
        binding.switchTicket.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                binding.rvTicketTicket.visibility = View.GONE
            else
                binding.rvTicketTicket.visibility = View.VISIBLE
        }
        viewModel.openProductEvent.observe(viewLifecycleOwner, EventObserver {
          setNavigationQR()
        })
    }

    private fun setNavigationQR() {
        Intent(activity, QrScanActivity::class.java).apply {
            startActivity(this)
        }
    }
}