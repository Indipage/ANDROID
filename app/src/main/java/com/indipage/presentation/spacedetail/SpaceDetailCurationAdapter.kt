package org.android.go.sopt.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.CurationData
import com.indipage.databinding.ItemSpaceDetailCurationBinding

class SpaceDetailCurationAdapter() :
    ListAdapter<CurationData, SpaceDetailCurationAdapter.CurationViewHolder>(
        SpaceDetailDiffCallback
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurationViewHolder {
        return CurationViewHolder(
            ItemSpaceDetailCurationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CurationViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class CurationViewHolder(private val binding: ItemSpaceDetailCurationBinding) :
        ViewHolder(binding.root) {
        fun onBind(data: CurationData) {
            binding.curation = data
        }
    }

    companion object {
        private val SpaceDetailDiffCallback =
            ItemDiffCallback<CurationData>(
                onItemsTheSame = { old, new -> old.bookData == new.bookData },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}