package com.indipage.presentation.ticket.card.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.indipage.databinding.ItemTicketCardBinding
import com.indipage.domain.entity.Card

class CardViewHolder(
    private val binding: ItemTicketCardBinding,
    private val onMoveToQrDetailClick: (Card) -> Unit = { _ -> }
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Card) {
        binding.card = data
        binding.tvTicketCard.setOnClickListener {
            onMoveToQrDetailClick(data)
        }
        binding.executePendingBindings()
    }
}