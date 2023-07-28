package com.indipage.presentation.articledetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.ResponseArticleDetailDto
import com.indipage.databinding.ItemArticleDetailBottomBinding
import com.indipage.domain.entity.ArticleDetail

class ArticleDetailBottomAdapter() :
    ListAdapter<ArticleDetail, ArticleDetailBottomAdapter.ArticleDetailBottomViewHolder>(
        ArticleAllDiffCallback
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ArticleDetailBottomViewHolder {
        val binding = ItemArticleDetailBottomBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ArticleDetailBottomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleDetailBottomViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ArticleDetailBottomViewHolder(
        private val binding: ItemArticleDetailBottomBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ArticleDetail) {
            with(binding) {
                articleDetail = data
                executePendingBindings()
            }
        }
    }

    companion object {
        private val ArticleAllDiffCallback = ItemDiffCallback<ArticleDetail>(
            onItemsTheSame = { old, new -> old.id == new.id },
            onContentsTheSame = { old, new -> old == new })
    }
}