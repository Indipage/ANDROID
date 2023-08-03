package com.indipage.ui.ticket.ticket.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.indipage.model.TicketModel
import com.indipage.presentation.databinding.ItemTicketTicketBinding

class TicketViewHolder(
    private val binding: ItemTicketTicketBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: TicketModel) {
        binding.ticket = data
        binding.executePendingBindings()
    }
}
