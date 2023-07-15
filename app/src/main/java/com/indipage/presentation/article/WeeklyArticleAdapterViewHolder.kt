package com.indipage.presentation.article

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.indipage.data.dto.response.ResponseWeeklyArticleDto
import com.indipage.databinding.ItemWeeklyArticleOpenBinding
import com.indipage.databinding.ItemWeeklyArticlePreBinding

class WeeklyArticleAdapterViewHolder {

    class ItemWeeklyArticleOpenViewHolder(private val binding: ItemWeeklyArticleOpenBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseWeeklyArticleDto) {
            with(binding) {
                tvItemWeeklyArticleTitle.text = data.title
                ivItemWeeklyArticlePlaceImage.load(data.thumbnail)
                tvItemWeeklyArticleSubTitle.text = data.subTitle
                tvItemWeeklyArticleAuthor.text = data.name
            }
        }
    }

    class ItemWeeklyArticlePreViewHolder(private val binding: ItemWeeklyArticlePreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseWeeklyArticleDto) {
            with(binding) {
                tvItemWeeklyArticlePreDate.text = data.date + "days"
                ivItemWeeklyArticlePlaceImage.load(data.thumbnail)
            }
        }
    }
}