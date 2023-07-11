package com.indipage.presentation.ticket

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.databinding.FragmentTicketBinding
import com.indipage.presentation.qr.QrScanActivity
import com.indipage.presentation.savedspace.SavedSpaceViewModel
import com.indipage.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class TicketFragment : BindingFragment<FragmentTicketBinding>(R.layout.fragment_ticket) {

    private lateinit var adapter: TicketAdapter
    private lateinit var adapter2: CardAdapter

    private val viewModel by viewModels<TicketViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TicketAdapter()
        adapter2 = CardAdapter()
        val spaceList = listOf(
            "https://avatars.githubusercontent.com/u/93514333?v=4",
            "https://avatars.githubusercontent.com/u/93514333?v=4",
            "https://avatars.githubusercontent.com/u/93514333?v=4",
            )
        binding.rvTicketTicket.adapter = adapter
        val itemTouchHelper = ItemTouchHelper(TicketItemHelper(viewModel))
        itemTouchHelper.attachToRecyclerView(binding.rvTicketTicket)
        adapter.submitList(spaceList)

        viewModel.openProductEvent.observe(viewLifecycleOwner, EventObserver {
            setNavigationQR()
        })
        binding.switchTicket.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)findNavController().navigate(
                R.id.action_navigation_ticket_to_navigation_card, bundleOf(
                ))
            else Timber.d("test")
        }
    }

    private fun setNavigationQR() {
        Intent(activity, QrScanActivity::class.java).apply {
            startActivity(this)
        }
    }
}