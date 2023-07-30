package com.indipage.ui.ticket.ticket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.domain.model.Ticket
import com.indipage.presentation.databinding.ItemTicketTicketBinding
import com.indipage.ui.ticket.ticket.viewholder.TicketViewHolder

class TicketAdapter : ListAdapter<Ticket, TicketViewHolder>(
    TicketDiffCalback
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
        private val TicketDiffCalback =
            ItemDiffCallback<Ticket>(
                onItemsTheSame = { old, new -> old.ticketId == new.ticketId },
                onContentsTheSame = { old, new -> old == new }
            )
    }

}