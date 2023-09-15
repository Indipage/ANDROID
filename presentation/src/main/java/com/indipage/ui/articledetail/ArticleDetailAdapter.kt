package com.indipage.ui.articledetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.presentation.databinding.ItemArticleDetailArticleBodyBinding
import com.indipage.presentation.databinding.ItemArticleDetailArticleImageBinding
import com.indipage.presentation.databinding.ItemArticleDetailArticleTitleBinding
import com.indipage.ui.articledetail.viewholder.ArticleDetailAdapterViewHolder
import com.indipage.util.ArticleDetailTag.BODY
import com.indipage.util.ArticleDetailTag.IMAGE
import com.indipage.util.ArticleDetailTag.TITLE

class ArticleDetailAdapter : ListAdapter<ArticleDetailParsing, RecyclerView.ViewHolder>(
    ArticleDetailAdapterDiffCallback
) {
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getItemViewType(position: Int): Int {
        return when {
            currentList[position].title != null -> TITLE
            currentList[position].image != null -> IMAGE
            else -> BODY
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TITLE -> {
                val binding = ItemArticleDetailArticleTitleBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                ArticleDetailAdapterViewHolder.ItemArticleDetailArticleTitleViewHolder(binding)
            }

            IMAGE -> {
                val binding = ItemArticleDetailArticleImageBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                ArticleDetailAdapterViewHolder.ItemArticleDetailArticleImageViewHolder(binding)
            }

            else -> {
                val binding = ItemArticleDetailArticleBodyBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                ArticleDetailAdapterViewHolder.ItemArticleDetailArticleBodyViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (currentList[position].title != null) {
            (holder as ArticleDetailAdapterViewHolder.ItemArticleDetailArticleTitleViewHolder).run {
                onBind(currentList[position])
            }
        } else if (currentList[position].image != null) {
            (holder as ArticleDetailAdapterViewHolder.ItemArticleDetailArticleImageViewHolder).run {
                onBind(currentList[position])
            }
        } else {
            (holder as ArticleDetailAdapterViewHolder.ItemArticleDetailArticleBodyViewHolder).run {
                onBind(currentList[position])
            }
        }
    }


    companion object {
        private val ArticleDetailAdapterDiffCallback = ItemDiffCallback<ArticleDetailParsing>(
            onItemsTheSame = { old, new -> old.spaceId == new.spaceId },
            onContentsTheSame = { old, new -> old == new })
    }
}