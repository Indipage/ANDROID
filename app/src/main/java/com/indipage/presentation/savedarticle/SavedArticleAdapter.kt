package com.indipage.presentation.savedarticle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.SavedArticle
import com.indipage.databinding.ItemSavedArticleBinding

class SavedArticleAdapter(
) : PagingDataAdapter<SavedArticle, SavedArticleAdapter.PagingViewHolder>(
    SavedArticleDiffCalback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        val binding =
            ItemSavedArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class PagingViewHolder(private val binding: ItemSavedArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SavedArticle) {
            binding.savedArticle = data
            binding.executePendingBindings()
        }
    }

    companion object {
        private val SavedArticleDiffCalback =
            ItemDiffCallback<SavedArticle>(
                onItemsTheSame = { old, new -> old.spaceName == new.spaceName },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}