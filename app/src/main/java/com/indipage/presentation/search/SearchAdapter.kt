package com.indipage.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.ResponseSearchData
import com.indipage.databinding.ItemSearchBinding

class SearchAdapter(private val viewModel: SearchViewModel) :
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
            binding.vm=viewModel
            binding.search = data
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