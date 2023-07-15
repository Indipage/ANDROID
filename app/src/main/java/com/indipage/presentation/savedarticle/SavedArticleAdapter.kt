package com.indipage.presentation.savedarticle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.ResponseArticleDto
import com.indipage.databinding.ItemSavedArticleBinding

class SavedArticleAdapter: ListAdapter<ResponseArticleDto, SavedArticleAdapter.SavedArticleViewHolder>(
    SavedArticleDiffCalback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedArticleViewHolder {
        val binding =
            ItemSavedArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SavedArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedArticleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SavedArticleViewHolder(
        private val binding: ItemSavedArticleBinding
    ) : ViewHolder(binding.root) {
        fun bind(data: ResponseArticleDto) {
            binding.savedArticle = data
            binding.executePendingBindings()
        }
    }

    companion object {
        private val SavedArticleDiffCalback =
            ItemDiffCallback<ResponseArticleDto>(
                onItemsTheSame = { old, new -> old.id == new.id},
                onContentsTheSame = { old, new -> old == new }
            )
    }
}