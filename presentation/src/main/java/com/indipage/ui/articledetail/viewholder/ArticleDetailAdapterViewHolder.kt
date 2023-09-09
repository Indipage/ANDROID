package com.indipage.ui.articledetail.viewholder

import android.annotation.SuppressLint
import android.text.method.LinkMovementMethod
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.indipage.presentation.databinding.ItemArticleDetailArticleBodyBinding
import com.indipage.presentation.databinding.ItemArticleDetailArticleImageBinding
import com.indipage.presentation.databinding.ItemArticleDetailArticleTitleBinding
import com.indipage.ui.articledetail.ArticleDetailParsing

class ArticleDetailAdapterViewHolder {
    class ItemArticleDetailArticleBodyViewHolder(private val binding: ItemArticleDetailArticleBodyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun onBind(data: ArticleDetailParsing) {
            val showTextView = !data.line

            with(binding) {
                tvItemArticleDetailArticleBody.isVisible = showTextView
                viewItemArticleDetailArticleBody.isVisible = !showTextView

                if (showTextView) {
                    tvItemArticleDetailArticleBody.text = data.body
                    tvItemArticleDetailArticleBody.movementMethod = LinkMovementMethod()
                }
            }
        }
    }

    class ItemArticleDetailArticleTitleViewHolder(private val binding: ItemArticleDetailArticleTitleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ArticleDetailParsing) {
            binding.tvItemArticleDetailArticleTitle.text = data.title
        }

    }

    class ItemArticleDetailArticleImageViewHolder(private val binding: ItemArticleDetailArticleImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ArticleDetailParsing) {
            binding.ivItemArticleDetailArticleImage.load(data.image)
        }
    }


}