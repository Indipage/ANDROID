package com.indipage.presentation.article

import androidx.recyclerview.widget.RecyclerView
import com.indipage.data.dto.response.ResponseArticleWeeklyDto
import com.indipage.databinding.ItemWeeklyArticleOpenBinding
import com.indipage.databinding.ItemWeeklyArticlePreBinding

class WeeklyArticleAdapterViewHolder() {
    class ItemWeeklyArticleOpenViewHolder(
        private val binding: ItemWeeklyArticleOpenBinding, private val model: ArticleViewModel
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseArticleWeeklyDto) {
            with(binding) {
                articleWeekly = data
                executePendingBindings()
                binding.viewModel = model
            }
        }
    }

    class ItemWeeklyArticlePreViewHolder(private val binding: ItemWeeklyArticlePreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseArticleWeeklyDto) {
            with(binding) {
                articleWeekly = data
                executePendingBindings()
            }
        }
    }
}