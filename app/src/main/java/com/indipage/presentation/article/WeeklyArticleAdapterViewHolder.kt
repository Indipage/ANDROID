package com.indipage.presentation.article

import android.content.Intent
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.indipage.R
import com.indipage.data.dto.response.ResponseWeeklyArticleDto
import com.indipage.databinding.ItemWeeklyArticleOpenBinding
import com.indipage.databinding.ItemWeeklyArticlePreBinding

class WeeklyArticleAdapterViewHolder {
    class ItemWeeklyArticleOpenViewHolder(private val binding: ItemWeeklyArticleOpenBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseWeeklyArticleDto) {
            with(binding) {
                ivItemWeeklyArticlePlaceImage.load(data.thumbnail)
                tvItemWeeklyArticleTitle.text = data.title
                tvItemWeeklyArticleSubTitle.text = data.subTitle
                tvItemWeeklyArticleAuthor.text = data.name
                root.setOnClickListener {
                    it.findNavController().navigate(R.id.action_article_to_article_detail)
                }
            }
        }
    }

    class ItemWeeklyArticlePreViewHolder(private val binding: ItemWeeklyArticlePreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseWeeklyArticleDto) {
            with(binding) {
                ivItemWeeklyArticlePlaceImage.load(data.thumbnail)
                tvItemWeeklyArticlePreDate.text = data.date + "Days"
            }
        }
    }
}