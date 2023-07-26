package com.indipage.presentation.savedarticle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.databinding.ItemSavedArticleBinding
import com.indipage.domain.entity.Article

class SavedArticleAdapter(
    private val onMoveToArticleDetailClick: (Article, Int) -> Unit = { _, _ -> }
) : ListAdapter<Article, SavedArticleAdapter.SavedArticleViewHolder>(
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

    inner class SavedArticleViewHolder(
        private val binding: ItemSavedArticleBinding
    ) : ViewHolder(binding.root) {
        fun bind(data: Article) {
            binding.savedArticle = data
            if (data.ticketReceived) {
                binding.clTicketTrue.visibility = View.VISIBLE
                binding.clTicketFalse.visibility = View.GONE
            } else {
                binding.clTicketTrue.visibility = View.GONE
                binding.clTicketFalse.visibility = View.VISIBLE
            }
            binding.clTicketTrue.setOnClickListener {
                onMoveToArticleDetailClick(data, position)
            }
            binding.clTicketFalse.setOnClickListener {
                onMoveToArticleDetailClick(data, position)
            }
            binding.executePendingBindings()
        }
    }

    companion object {
        private val SavedArticleDiffCalback =
            ItemDiffCallback<Article>(
                onItemsTheSame = { old, new -> old.id == new.id },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}