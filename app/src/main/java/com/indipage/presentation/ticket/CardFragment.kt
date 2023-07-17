package com.indipage.presentation.ticket

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.core_ui.base.BindingFragment
import com.example.core_ui.view.UiState
import com.indipage.R
import com.indipage.databinding.FragmentCardBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class CardFragment : BindingFragment<FragmentCardBinding>(R.layout.fragment_card) {

    private lateinit var adapter: CardAdapter

    private val viewModel by viewModels<CardViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initView()
        moveToTicket()
    }

    private fun initAdapter() {
        adapter = CardAdapter()
        binding.rvTicketCard.adapter = adapter
    }

    private fun initView() {
        viewModel.card.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    adapter.submitList(it.data)
                    binding.ivTicketCard.load(it.data[0].imageUrl)
                    binding.coCardEmptyView.visibility =
                        if (it.data.isEmpty()) View.VISIBLE else View.GONE
                }
                else -> {}
            }
        }.launchIn(lifecycleScope)
        binding.switchTicket.isChecked = true
    }

    private fun moveToTicket() {
        binding.switchTicket.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                Handler().postDelayed({
                    findNavController()
                        .navigate(R.id.action_navigation_card_to_navigation_ticket, bundleOf())
                }, 100)
            }
        }
    }

}