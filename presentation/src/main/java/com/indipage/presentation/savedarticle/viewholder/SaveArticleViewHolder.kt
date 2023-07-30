package com.indipage.presentation.savedarticle.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.indipage.domain.model.Article
import com.indipage.presentation.databinding.ItemSavedArticleBinding

class SavedArticleViewHolder(
    private val binding: ItemSavedArticleBinding,
    private val onMoveToArticleDetailClick: (Article, Int) -> Unit = { _, _ -> }
) : RecyclerView.ViewHolder(binding.root) {
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