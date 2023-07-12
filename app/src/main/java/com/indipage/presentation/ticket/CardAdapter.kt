package com.indipage.presentation.ticket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.databinding.ItemTicketCardBinding
import com.indipage.databinding.ItemTicketTicketBinding

class CardAdapter() : ListAdapter<String, CardAdapter.TicketViewHolder>(
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

    class TicketViewHolder(
        private val binding: ItemTicketCardBinding
    ) : ViewHolder(binding.root) {
        fun bind(data: String) {
            binding.testUrl = data
            binding.executePendingBindings()
        }
    }


    companion object {
        private val CardDiffCalback =
            ItemDiffCallback<String>(
                onItemsTheSame = { old, new -> old == new },
                onContentsTheSame = { old, new -> old == new }
            )
    }

}