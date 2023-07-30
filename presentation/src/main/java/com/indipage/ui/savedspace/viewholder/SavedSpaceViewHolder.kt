package com.indipage.ui.savedspace.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.indipage.domain.model.Space
import com.indipage.presentation.databinding.ItemSavedSpaceBinding

class SavedSpaceViewHolder(
    private val binding: ItemSavedSpaceBinding,
    private val onMoveToSpaceDetailClick: (Space, Int) -> Unit = { _, _ -> }
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Space) {
        binding.savedSpace = data
        binding.root.setOnClickListener {
            onMoveToSpaceDetailClick(data,position)
        }
        binding.executePendingBindings()
    }
}