package com.indipage.presentation.articledetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.domain.model.ArticleDetail
import com.indipage.presentation.articledetail.viewholder.ArticleDetailBottomViewHolder
import com.indipage.presentation.databinding.ItemArticleDetailBottomBinding

class ArticleDetailBottomAdapter() :
    ListAdapter<ArticleDetail, ArticleDetailBottomViewHolder>(
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

    companion object {
        private val ArticleAllDiffCallback = ItemDiffCallback<ArticleDetail>(
            onItemsTheSame = { old, new -> old.id == new.id },
            onContentsTheSame = { old, new -> old == new })
    }
}