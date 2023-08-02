package com.indipage.ui.ticket.card.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.indipage.model.CardModel
import com.indipage.presentation.databinding.ItemTicketCardBinding

class CardViewHolder(
    private val binding: ItemTicketCardBinding,
    private val onMoveToQrDetailClick: (CardModel) -> Unit = { _ -> }
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: CardModel) {
        binding.card = data
        binding.tvTicketCard.setOnClickListener {
            onMoveToQrDetailClick(data)
        }
        binding.executePendingBindings()
    }
}