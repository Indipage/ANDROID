package com.indipage.ui.savedarticle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.domain.model.Article
import com.indipage.presentation.databinding.ItemSavedArticleBinding
import com.indipage.ui.savedarticle.viewholder.SavedArticleViewHolder

class SavedArticleAdapter(
    private val onMoveToArticleDetailClick: (Article, Int) -> Unit = { _, _ -> }
) : ListAdapter<Article, SavedArticleViewHolder>(
    SavedArticleDiffCalback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedArticleViewHolder {
        val binding =
            ItemSavedArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SavedArticleViewHolder(binding,onMoveToArticleDetailClick)
    }

    override fun onBindViewHolder(holder: SavedArticleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val SavedArticleDiffCalback =
            ItemDiffCallback<Article>(
                onItemsTheSame = { old, new -> old.id == new.id },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}