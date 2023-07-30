package com.indipage.ui.ticket.card

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.domain.model.Card
import com.indipage.presentation.databinding.ItemTicketCardBinding
import com.indipage.ui.ticket.card.viewholder.CardViewHolder

class CardAdapter(private val onMoveToQrDetailClick: (Card) -> Unit = { _ -> }) : ListAdapter<Card, CardViewHolder>(
    CardDiffCalback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding =
            ItemTicketCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding,onMoveToQrDetailClick)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        private val CardDiffCalback =
            ItemDiffCallback<Card>(
                onItemsTheSame = { old, new -> old.cardId == new.cardId },
                onContentsTheSame = { old, new -> old == new }
            )
    }

}