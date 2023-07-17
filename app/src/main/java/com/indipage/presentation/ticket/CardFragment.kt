package com.indipage.presentation.ticket

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.databinding.FragmentCardBinding
import kotlinx.coroutines.delay
import timber.log.Timber

class CardFragment : BindingFragment<FragmentCardBinding>(R.layout.fragment_card) {

    private lateinit var adapter: CardAdapter

    private val viewModel by viewModels<TicketViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val spaceList = listOf(
            "https://avatars.githubusercontent.com/u/93514333?v=4",
            "https://avatars.githubusercontent.com/u/93514333?v=4",
            "https://avatars.githubusercontent.com/u/93514333?v=4",
        )
        binding.testImageUrl = "https://avatars.githubusercontent.com/u/93514333?v=4"
        initAdapter()
        initView(spaceList)
        moveToTicket()
    }
    private fun initAdapter() {
        adapter = CardAdapter()
        binding.rvTicketCard.adapter = adapter
    }
    private fun initView(spaceList: List<String>) {
        adapter.submitList(spaceList)
        binding.switchTicket.isChecked = true
        binding.coCardEmptyView.visibility = if (spaceList.isEmpty()) View.VISIBLE else View.GONE
    }

    private fun moveToTicket() {
        binding.switchTicket.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Timber.d("good")
            } else if (!isChecked) {
                Handler().postDelayed({
                    findNavController()
                        .navigate(R.id.action_navigation_card_to_navigation_ticket, bundleOf())
                }, 100)
            }
        }
    }

}