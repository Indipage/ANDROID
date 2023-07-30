package com.indipage.presentation.ticket.ticket.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.indipage.domain.model.Ticket
import com.indipage.presentation.databinding.ItemTicketTicketBinding

class TicketViewHolder(
    private val binding: ItemTicketTicketBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Ticket) {
        binding.ticket = data
        binding.executePendingBindings()
    }
}
