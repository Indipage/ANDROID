package com.indipage.ui.ticket.card.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.indipage.domain.model.Card
import com.indipage.presentation.databinding.ItemTicketCardBinding

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