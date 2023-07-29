package com.indipage.presentation.article

import androidx.recyclerview.widget.RecyclerView
import com.indipage.databinding.ItemWeeklyArticleOpenBinding
import com.indipage.databinding.ItemWeeklyArticlePreBinding
import com.indipage.domain.model.ArticleWeekly

class WeeklyArticleAdapterViewHolder() {
    class ItemWeeklyArticleOpenViewHolder(
        private val binding: ItemWeeklyArticleOpenBinding,
        private val onMoveToArticleDetailClick: (ArticleWeekly, Int) -> Unit = { _, _ -> }
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ArticleWeekly) {
            with(binding) {
                articleWeekly = data
                binding.root.setOnClickListener {
                    onMoveToArticleDetailClick(data,position)
                }
                executePendingBindings()
            }
        }
    }

    class ItemWeeklyArticlePreViewHolder(private val binding: ItemWeeklyArticlePreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ArticleWeekly) {
            with(binding) {
                articleWeekly = data
                executePendingBindings()
            }
        }
    }
}