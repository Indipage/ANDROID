package com.indipage.presentation.article

import androidx.recyclerview.widget.RecyclerView
import com.indipage.data.dto.response.ResponseArticleAllDto
import com.indipage.data.dto.response.ResponseArticleWeeklyDto
import com.indipage.databinding.ItemWeeklyArticleOpenBinding
import com.indipage.databinding.ItemWeeklyArticlePreBinding

class WeeklyArticleAdapterViewHolder() {
    class ItemWeeklyArticleOpenViewHolder(
        private val binding: ItemWeeklyArticleOpenBinding,
        private val onMoveToArticleDetailClick: (ResponseArticleWeeklyDto, Int) -> Unit = { _, _ -> }
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseArticleWeeklyDto) {
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
        fun onBind(data: ResponseArticleWeeklyDto) {
            with(binding) {
                articleWeekly = data
                executePendingBindings()
            }
        }
    }
}