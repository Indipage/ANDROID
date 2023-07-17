package com.indipage.presentation.article

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.ResponseWeeklyArticleDto
import com.indipage.databinding.ItemWeeklyArticleOpenBinding
import com.indipage.databinding.ItemWeeklyArticlePreBinding
import com.indipage.util.WeeklyArticle.ITEM_OPEN
import com.indipage.util.WeeklyArticle.ITEM_PRE

class WeeklyArticleAdapter : ListAdapter<ResponseWeeklyArticleDto, RecyclerView.ViewHolder>(
    WeeklyArticleAdapterDiffCallback
) {
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) ITEM_OPEN
        else ITEM_PRE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ITEM_OPEN) {
            val binding = ItemWeeklyArticleOpenBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            WeeklyArticleAdapterViewHolder.ItemWeeklyArticleOpenViewHolder(binding)
        } else {
            val binding = ItemWeeklyArticlePreBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            WeeklyArticleAdapterViewHolder.ItemWeeklyArticlePreViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == ITEM_OPEN) {
            (holder as WeeklyArticleAdapterViewHolder.ItemWeeklyArticleOpenViewHolder).run {
                onBind(currentList[position])
            }
        } else {
            (holder as WeeklyArticleAdapterViewHolder.ItemWeeklyArticlePreViewHolder).run {
                onBind(currentList[position])
            }
        }
    }

    companion object {
        private val WeeklyArticleAdapterDiffCallback =
            ItemDiffCallback<ResponseWeeklyArticleDto>(
                onItemsTheSame = { old, new -> old.title == new.title },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}