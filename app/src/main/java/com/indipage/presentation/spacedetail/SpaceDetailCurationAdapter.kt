package org.android.go.sopt.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.indipage.data.dto.response.MockCurationData
import com.indipage.databinding.ItemSpaceDetailCurationBinding


class SpaceDetailCurationAdapter :
    ListAdapter<MockCurationData, SpaceDetailCurationAdapter.CurationViewHolder>(
        SpaceDetailDiffCallback()
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
        fun onBind(data: MockCurationData) {
            binding.curation = data
        }
    }
}

class SpaceDetailDiffCallback : DiffUtil.ItemCallback<MockCurationData>() {
    override fun areItemsTheSame(
        oldItem: MockCurationData,
        newItem: MockCurationData
    ): Boolean {
        return oldItem.bookData == newItem.bookData
    }

    override fun areContentsTheSame(
        oldItem: MockCurationData,
        newItem: MockCurationData
    ): Boolean {
        return oldItem == newItem
    }
}