package com.indipage.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.ResponseSearchData
import com.indipage.databinding.ItemSearchBinding

class SearchAdapter() :
    ListAdapter<ResponseSearchData, SearchAdapter.SearchViewHolder>(SearchDiffCalback) {
    private val searchResults = mutableListOf<ResponseSearchData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding =
            ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SearchViewHolder(
        private val binding: ItemSearchBinding
    ) : ViewHolder(binding.root) {
        fun bind(data: ResponseSearchData) {
            binding.search = data
        }
    }

    companion object {
        private val SearchDiffCalback =
            ItemDiffCallback<ResponseSearchData>(
                onItemsTheSame = { old, new -> old == new },
                onContentsTheSame = { old, new -> old == new }
            )
    }

    override fun getItemCount(): Int = searchResults.size
    fun updateSearchResults(newSearchResults: MutableList<ResponseSearchData>) {
        searchResults.clear()
        searchResults.addAll(newSearchResults)
        notifyDataSetChanged()
    }
}