package com.indipage.ui.savedspace

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.model.SpaceModel
import com.indipage.presentation.databinding.ItemSavedSpaceBinding
import com.indipage.ui.savedspace.viewholder.SavedSpaceViewHolder

class SavedSpaceAdapter(
    private val onMoveToSpaceDetailClick: (SpaceModel, Int) -> Unit = { _, _ -> }
    ):
    ListAdapter<SpaceModel, SavedSpaceViewHolder>(
    SavedSpaceDiffCalback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedSpaceViewHolder {
        val binding =
            ItemSavedSpaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SavedSpaceViewHolder(binding,onMoveToSpaceDetailClick)
    }

    override fun onBindViewHolder(holder: SavedSpaceViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val SavedSpaceDiffCalback =
            ItemDiffCallback<SpaceModel>(
                onItemsTheSame = { old, new -> old.id == new.id },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}