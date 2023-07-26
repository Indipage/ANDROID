package com.indipage.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.ResponseSearchData
import com.indipage.databinding.ItemSearchBinding
import com.indipage.domain.entity.Space

class SearchAdapter( private val onMoveToSpaceDetailClick: (ResponseSearchData, Int) -> Unit = { _, _ -> }) :
    ListAdapter<ResponseSearchData, SearchAdapter.SearchViewHolder>(SearchDiffCalback) {

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
        fun bind(data: ResponseSearchData) {
            binding.search = data
            binding.root.setOnClickListener {
                onMoveToSpaceDetailClick(data,position)
            }
            binding.executePendingBindings()
        }
    }

    companion object {
        private val SearchDiffCalback =
            ItemDiffCallback<ResponseSearchData>(
                onItemsTheSame = { old, new -> old.spaceId == new.spaceId },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}