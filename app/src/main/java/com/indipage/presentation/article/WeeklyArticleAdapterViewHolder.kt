package com.indipage.presentation.article

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.indipage.R
import com.indipage.data.dto.response.ResponseArticleWeeklyDto
import com.indipage.databinding.ItemWeeklyArticleOpenBinding
import com.indipage.databinding.ItemWeeklyArticlePreBinding

class WeeklyArticleAdapterViewHolder {
    class ItemWeeklyArticleOpenViewHolder(private val binding: ItemWeeklyArticleOpenBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseArticleWeeklyDto) {
            with(binding) {
                ivItemWeeklyArticlePlaceImage.load(data.thumbnailUrlOfThisWeek)
                tvItemWeeklyArticleTitle.text = data.spaceName
                tvItemWeeklyArticleSubTitle.text = data.title
                tvItemWeeklyArticleAuthor.text = data.spaceOwner
                root.setOnClickListener {
                    it.findNavController().navigate(R.id.action_article_to_article_detail)
                }
            }
        }
    }

    class ItemWeeklyArticlePreViewHolder(private val binding: ItemWeeklyArticlePreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseArticleWeeklyDto) {
            with(binding) {
                ivItemWeeklyArticlePlaceImage.load(data.thumbnailUrlOfNextWeek)
                tvItemWeeklyArticlePreDate.text = data.remainingDays.toString() + "Days"
            }
        }
    }
}