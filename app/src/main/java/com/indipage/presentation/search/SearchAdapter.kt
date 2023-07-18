package com.indipage.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.ResponseSearchData.SearchDetailData
import com.indipage.databinding.ItemSearchBinding

class SearchAdapter() :
    ListAdapter<SearchDetailData, SearchAdapter.SearchViewHolder>(SearchDiffCalback) {
    private val searchResults = mutableListOf<SearchDetailData>()

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
        fun bind(data: SearchDetailData) {
            binding.search = data
        }
    }

    companion object {
        private val SearchDiffCalback =
            ItemDiffCallback<SearchDetailData>(
                onItemsTheSame = { old, new -> old.name == new.name },
                onContentsTheSame = { old, new -> old == new }
            )
    }

    //    override fun getItemCount(): Int = searchResults.size
    fun updateSearchResults(newSearchResults: MutableList<SearchDetailData>) {
        searchResults.clear()
        searchResults.addAll(newSearchResults)
        notifyDataSetChanged()
    }
}



