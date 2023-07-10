package com.indipage.presentation.savedarticle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.SavedArticle
import com.indipage.databinding.ItemSavedArticleBinding

class SavedArticleAdapter(
) : ListAdapter<SavedArticle, SavedArticleAdapter.SavedArticleViewHolder>(
    SavedArticleDiffCalback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedArticleViewHolder {
        val binding =
            ItemSavedArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SavedArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedArticleViewHolder, position: Int) {
//        getItem(position)?.let { holder.bind(it) }
        holder.bind(getItem(position))
    }

    class SavedArticleViewHolder(
        private val binding: ItemSavedArticleBinding
    ) : ViewHolder(binding.root) {
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