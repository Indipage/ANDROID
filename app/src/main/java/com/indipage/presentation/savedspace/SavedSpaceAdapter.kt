package com.indipage.presentation.savedspace

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.ResponseSpaceDto
import com.indipage.data.dto.response.SavedSpace
import com.indipage.databinding.ItemSavedSpaceBinding

class SavedSpaceAdapter(private val viewModel:SavedSpaceViewModel):
    ListAdapter<ResponseSpaceDto, SavedSpaceAdapter.SavedSpaceViewHolder>(
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
        fun bind(data: ResponseSpaceDto) {
            binding.savedSpace = data
            binding.vm= viewModel
            binding.executePendingBindings()
        }
    }

    companion object {
        private val SavedSpaceDiffCalback =
            ItemDiffCallback<ResponseSpaceDto>(
                onItemsTheSame = { old, new -> old.id == new.id },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}