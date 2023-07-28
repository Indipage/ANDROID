package com.indipage.presentation.articledetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.databinding.ItemArticleDetailArticleBodyBinding
import com.indipage.databinding.ItemArticleDetailArticleImageBinding
import com.indipage.databinding.ItemArticleDetailArticleTitleBinding
import com.indipage.presentation.articledetail.viewholder.ArticleDetailAdapterViewHolder
import com.indipage.util.ArticleDetailTag.BODY
import com.indipage.util.ArticleDetailTag.BODY_TAG_REGEX
import com.indipage.util.ArticleDetailTag.IMAGE
import com.indipage.util.ArticleDetailTag.IMAGE_TAG_REGEX
import com.indipage.util.ArticleDetailTag.TITLE
import com.indipage.util.ArticleDetailTag.TITLE_TAG_REGEX

class ArticleDetailAdapter : ListAdapter<ArticleDetailData, RecyclerView.ViewHolder>(
    ArticleDetailAdapterDiffCallback
) {
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getItemViewType(position: Int): Int {
        return if (currentList[position].body.contains(TITLE_TAG_REGEX)) {
            TITLE
        } else if (currentList[position].body.contains(IMAGE_TAG_REGEX)) {
            IMAGE
        } else if (currentList[position].body.contains(BODY_TAG_REGEX)) {
            BODY
        } else {
            BODY
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TITLE -> {
                val binding = ItemArticleDetailArticleTitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ArticleDetailAdapterViewHolder.ItemArticleDetailArticleTitleViewHolder(binding)
            }
            IMAGE -> {
                val binding = ItemArticleDetailArticleImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ArticleDetailAdapterViewHolder.ItemArticleDetailArticleImageViewHolder(binding)
            }
            else -> {
                val binding = ItemArticleDetailArticleBodyBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ArticleDetailAdapterViewHolder.ItemArticleDetailArticleBodyViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (currentList[position].body.contains(TITLE_TAG_REGEX)) {
            (holder as ArticleDetailAdapterViewHolder.ItemArticleDetailArticleTitleViewHolder).run {
                onBind(currentList[position])
            }
        } else if (currentList[position].body.contains(IMAGE_TAG_REGEX)) {
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
        private val ArticleDetailAdapterDiffCallback =
            ItemDiffCallback<ArticleDetailData>(
                onItemsTheSame = { old, new -> old.body == new.body },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}