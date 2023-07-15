package com.indipage.presentation.savedspace

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.SavedSpace
import com.indipage.databinding.ItemSavedSpaceBinding

class SavedSpaceAdapter: ListAdapter<SavedSpace, SavedSpaceAdapter.SavedSpaceViewHolder>(
    SavedSpaceDiffCalback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedSpaceViewHolder {
        val binding =
            ItemSavedSpaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SavedSpaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedSpaceViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SavedSpaceViewHolder(
        private val binding: ItemSavedSpaceBinding
    ) : ViewHolder(binding.root) {
        fun bind(data: SavedSpace) {
            binding.savedSpace = data
            binding.executePendingBindings()
        }
    }

    companion object {
        private val SavedSpaceDiffCalback =
            ItemDiffCallback<SavedSpace>(
                onItemsTheSame = { old, new -> old.spaceName == new.spaceName },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}