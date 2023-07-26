package com.indipage.presentation.savedspace

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.databinding.ItemSavedSpaceBinding
import com.indipage.domain.entity.Space

class SavedSpaceAdapter(
    private val onMoveToSpaceDetailClick: (Space, Int) -> Unit = { _, _ -> }
    ):
    ListAdapter<Space, SavedSpaceAdapter.SavedSpaceViewHolder>(
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

    inner class SavedSpaceViewHolder(
        private val binding: ItemSavedSpaceBinding
    ) : ViewHolder(binding.root) {
        fun bind(data: Space) {
            binding.savedSpace = data
            binding.root.setOnClickListener {
                onMoveToSpaceDetailClick(data,position)
            }
            binding.executePendingBindings()
        }
    }

    companion object {
        private val SavedSpaceDiffCalback =
            ItemDiffCallback<Space>(
                onItemsTheSame = { old, new -> old.id == new.id },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}