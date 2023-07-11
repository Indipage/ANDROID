package com.indipage.presentation.ticket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.SavedSpace
import com.indipage.databinding.ItemSavedSpaceBinding
import com.indipage.databinding.ItemTicketTicketBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

class TicketAdapter() : ListAdapter<String, TicketAdapter.TicketViewHolder>(
    SavedSpaceDiffCalback
){
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
        fun bind(data: String) {
            binding.data = data
            binding.executePendingBindings()
        }
    }


    companion object {
        private val SavedSpaceDiffCalback =
            ItemDiffCallback<String>(
                onItemsTheSame = { old, new -> old == new },
                onContentsTheSame = { old, new -> old == new }
            )
    }

}