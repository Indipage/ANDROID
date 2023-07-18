package com.indipage.presentation.article

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.indipage.R
import com.indipage.data.dto.response.ResponseArticleWeeklyDto
import com.indipage.databinding.ItemWeeklyArticleOpenBinding
import com.indipage.databinding.ItemWeeklyArticlePreBinding

class WeeklyArticleAdapterViewHolder {
    class ItemWeeklyArticleOpenViewHolder(private val binding: ItemWeeklyArticleOpenBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseArticleWeeklyDto) {
            with(binding) {
                articleWeekly = data
                executePendingBindings()
                root.setOnClickListener {
                    val bundle = Bundle().apply {
                        putLong("articleId", data.id.toLong())
                    }
                    it.findNavController().navigate(R.id.action_article_to_article_detail,bundle)
                }
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