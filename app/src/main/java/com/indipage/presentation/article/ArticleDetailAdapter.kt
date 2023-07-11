package com.indipage.presentation.article

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.databinding.ItemArticleDetailArticleBodyBinding
import com.indipage.databinding.ItemArticleDetailArticleImageBinding
import com.indipage.databinding.ItemArticleDetailArticleTitleBinding


class ArticleDetailAdapter : ListAdapter<ArticleDetailData, RecyclerView.ViewHolder>(
    ArticleDetailAdapterDiffCallback
) {
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getItemViewType(position: Int): Int {
        return if (currentList[position].body.contains(TITLE_TAG_REGEX)) {
            TITLE
        } else if (currentList[position].body.contains(IMAGE_TAG_REGEX)) {
            IMAGE
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
                ItemArticleDetailArticleTitleViewHolder(binding)
            }
            IMAGE -> {
                val binding = ItemArticleDetailArticleImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ItemArticleDetailArticleImageViewHolder(binding)
            }
            else -> {
                val binding = ItemArticleDetailArticleBodyBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ItemArticleDetailArticleBodyViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (currentList[position].body.contains(TITLE_TAG_REGEX)) {
            (holder as ItemArticleDetailArticleTitleViewHolder).run {
                onBind(currentList[position])
            }
        } else if (currentList[position].body.contains(IMAGE_TAG_REGEX)) {
            (holder as ItemArticleDetailArticleImageViewHolder).run {
                onBind(currentList[position])
            }
        } else {
            (holder as ItemArticleDetailArticleBodyViewHolder).run {
                onBind(currentList[position])
            }
        }
    }

    class ItemArticleDetailArticleBodyViewHolder(private val binding: ItemArticleDetailArticleBodyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ArticleDetailData) {

            binding.tvItemArticleDetailArticleBody.text = data.body
        }
    }

    class ItemArticleDetailArticleTitleViewHolder(private val binding: ItemArticleDetailArticleTitleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ArticleDetailData) {
            var articleTitle = data.body.replace("<title>", "")
            articleTitle = articleTitle.replace("</title>", "")
            binding.tvItemArticleDetailArticleTitle.text = articleTitle
        }

    }

    class ItemArticleDetailArticleImageViewHolder(private val binding: ItemArticleDetailArticleImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ArticleDetailData) {
            var articleImage = data.body.replace("<img>", "")
            articleImage = articleImage.replace("</img>", "")
            binding.ivItemArticleDetailArticleImage.load(articleImage)
        }
    }

    companion object {
        val IMAGE_TAG_REGEX = "(<img>.*?</img>)".toRegex()
        val TITLE_TAG_REGEX = "(<title>.*?</title>)".toRegex()

        const val TITLE = 0
        const val IMAGE = 1
        const val BODY = 2

        private val ArticleDetailAdapterDiffCallback =
            ItemDiffCallback<ArticleDetailData>(
                onItemsTheSame = { old, new -> old.body == new.body },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}