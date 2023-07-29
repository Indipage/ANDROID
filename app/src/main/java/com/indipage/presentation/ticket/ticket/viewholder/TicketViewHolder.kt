package com.indipage.presentation.ticket.ticket.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.indipage.databinding.ItemTicketTicketBinding
import com.indipage.domain.model.Ticket

class TicketViewHolder(
    private val binding: ItemTicketTicketBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Ticket) {
        binding.ticket = data
        binding.executePendingBindings()
    }
}
