package com.indipage.ui.ticket.card

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.model.CardModel
import com.indipage.presentation.databinding.ItemTicketCardBinding
import com.indipage.ui.ticket.card.viewholder.CardViewHolder

class CardAdapter(private val onMoveToQrDetailClick: (CardModel) -> Unit = { _ -> }) :
    ListAdapter<CardModel, CardViewHolder>(
        CardDiffCalback
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding =
            ItemTicketCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding, onMoveToQrDetailClick)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        private val CardDiffCalback =
            ItemDiffCallback<CardModel>(
                onItemsTheSame = { old, new -> old.cardId == new.cardId },
                onContentsTheSame = { old, new -> old == new }
            )
    }

}