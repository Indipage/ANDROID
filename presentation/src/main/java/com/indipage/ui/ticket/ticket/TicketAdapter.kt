package com.indipage.ui.ticket.ticket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.model.TicketModel
import com.indipage.presentation.databinding.ItemTicketTicketBinding
import com.indipage.ui.ticket.ticket.viewholder.TicketViewHolder

class TicketAdapter : ListAdapter<TicketModel, TicketViewHolder>(
    TicketDiffCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val binding =
            ItemTicketTicketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TicketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        private val TicketDiffCallback =
            ItemDiffCallback<TicketModel>(
                onItemsTheSame = { old, new -> old.ticketId == new.ticketId },
                onContentsTheSame = { old, new -> old == new }
            )
    }

}