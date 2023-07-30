package com.indipage.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.domain.model.Search
import com.indipage.presentation.databinding.ItemSearchBinding

class SearchAdapter(private val onMoveToSpaceDetailClick: (Search, Int) -> Unit = { _, _ -> }) :
    ListAdapter<Search, SearchAdapter.SearchViewHolder>(SearchDiffCalback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding =
            ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SearchViewHolder(
        private val binding: ItemSearchBinding
    ) : ViewHolder(binding.root) {
        fun bind(data: Search) {
            binding.search = data
            binding.root.setOnClickListener {
                onMoveToSpaceDetailClick(data, position)
            }
            binding.executePendingBindings()
        }
    }

    companion object {
        private val SearchDiffCalback =
            ItemDiffCallback<Search>(
                onItemsTheSame = { old, new -> old.spaceId == new.spaceId },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}