package com.indipage.ui.articleall

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.domain.model.ArticleAll
import com.indipage.presentation.databinding.ItemArticleAllBinding
import com.indipage.ui.articleall.viewholder.ArticleAllViewHolder


class ArticleAllAdapter(
    private val onMoveToArticleDetailClick: (ArticleAll, Int) -> Unit = { _, _ -> }
) :
    ListAdapter<ArticleAll, ArticleAllViewHolder>(
        ArticleAllDiffCallback
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleAllViewHolder {
        val binding =
            ItemArticleAllBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleAllViewHolder(binding, onMoveToArticleDetailClick)
    }

    override fun onBindViewHolder(holder: ArticleAllViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val ArticleAllDiffCallback =
            ItemDiffCallback<ArticleAll>(onItemsTheSame = { old, new -> old.spaceName == new.spaceName },
                onContentsTheSame = { old, new -> old == new })
    }
}