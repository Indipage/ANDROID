package com.indipage.presentation.ticket

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.databinding.FragmentCardBinding
import timber.log.Timber

class CardFragment : BindingFragment<FragmentCardBinding>(R.layout.fragment_card) {

    private lateinit var adapter: CardAdapter

    private val viewModel by viewModels<TicketViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CardAdapter()
        val spaceList = listOf(
            "https://avatars.githubusercontent.com/u/93514333?v=4",
            "https://avatars.githubusercontent.com/u/93514333?v=4",
            "https://avatars.githubusercontent.com/u/93514333?v=4",
        )
        binding.testImageUrl = "https://avatars.githubusercontent.com/u/93514333?v=4"
        binding.rvTicketCard.adapter = adapter
        adapter.submitList(spaceList)
        binding.switchTicket.isChecked = true
        binding.coCardEmptyView.visibility = if (spaceList.isEmpty()) View.VISIBLE else View.GONE

        moveToTicket()
    }

    private fun moveToTicket() {
        binding.switchTicket.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) Timber.d("good")
            else findNavController().navigate(
                R.id.action_navigation_card_to_navigation_ticket,
                bundleOf()
            )
        }
    }
}