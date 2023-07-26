package com.indipage.presentation.ticket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.ResponseTicketDto
import com.indipage.databinding.ItemTicketTicketBinding
import com.indipage.domain.entity.Ticket

class TicketAdapter : ListAdapter<Ticket, TicketAdapter.TicketViewHolder>(
    TicketDiffCalback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val binding =
            ItemTicketTicketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TicketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class TicketViewHolder(
        private val binding: ItemTicketTicketBinding
    ) : ViewHolder(binding.root) {
        fun bind(data: Ticket) {
            binding.ticket = data
            binding.executePendingBindings()
        }
    }

    companion object {
        private val TicketDiffCalback =
            ItemDiffCallback<Ticket>(
                onItemsTheSame = { old, new -> old.ticketId == new.ticketId },
                onContentsTheSame = { old, new -> old == new }
            )
    }

}