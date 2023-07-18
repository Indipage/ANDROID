package com.indipage.presentation.ticket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.ResponseCardDto
import com.indipage.databinding.ItemTicketCardBinding
import com.indipage.domain.entity.Card
import com.indipage.presentation.model.CardModel

class CardAdapter(private val viewModel:CardViewModel) : ListAdapter<ResponseCardDto, CardAdapter.TicketViewHolder>(
    CardDiffCalback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val binding =
            ItemTicketCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TicketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

   inner class TicketViewHolder(
        private val binding: ItemTicketCardBinding
    ) : ViewHolder(binding.root) {
        fun bind(data: ResponseCardDto) {
            binding.card = data
            binding.vm=viewModel
            binding.executePendingBindings()
        }
    }

    companion object {
        private val CardDiffCalback =
            ItemDiffCallback<ResponseCardDto>(
                onItemsTheSame = { old, new -> old.cardId == new.cardId },
                onContentsTheSame = { old, new -> old == new }
            )
    }

}