package com.indipage.presentation.article

import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.databinding.ItemArticleDetailArticleBodyBinding
import com.indipage.databinding.ItemArticleDetailArticleImageBinding
import com.indipage.databinding.ItemArticleDetailArticleTitleBinding
import com.indipage.util.ArticleDetailTag

class ArticleDetailAdapter : ListAdapter<ArticleDetailData, RecyclerView.ViewHolder>(
    ArticleDetailAdapterDiffCallback
) {
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getItemViewType(position: Int): Int {
        return if (currentList[position].body.contains(ArticleDetailTag.TITLE_TAG_REGEX)) {
            ArticleDetailTag.TITLE
        } else if (currentList[position].body.contains(ArticleDetailTag.IMAGE_TAG_REGEX)) {
            ArticleDetailTag.IMAGE
        } else if (currentList[position].body.contains(ArticleDetailTag.BODY_TAG_REGEX)) {
            ArticleDetailTag.BODY
        } else {
            ArticleDetailTag.BODY
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ArticleDetailTag.TITLE -> {
                val binding = ItemArticleDetailArticleTitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ItemArticleDetailArticleTitleViewHolder(binding)
            }
            ArticleDetailTag.IMAGE -> {
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
        if (currentList[position].body.contains(ArticleDetailTag.TITLE_TAG_REGEX)) {
            (holder as ItemArticleDetailArticleTitleViewHolder).run {
                onBind(currentList[position])
            }
        } else if (currentList[position].body.contains(ArticleDetailTag.IMAGE_TAG_REGEX)) {
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

        private val clickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                Toast.makeText(view.context, "문학 칵테일 클릭 이벤트", Toast.LENGTH_SHORT).show()
            }

            override fun updateDrawState(ds: TextPaint) {
                ds.isUnderlineText = true
            }
        }

        fun onBind(data: ArticleDetailData) {
            var articleBody = data.body
            articleBody = articleBody.replace(ArticleDetailTag.REPLACE_TAG_REGEX, "")
            binding.tvItemArticleDetailArticleBody.movementMethod = LinkMovementMethod()

            var spannable = SpannableStringBuilder(articleBody).apply {
                ArticleDetailTag.COLOR_TAG_REGEX.findAll(articleBody).forEach { matchResult ->
                    setSpan(
                        ForegroundColorSpan(Color.parseColor("#AA59FC")),
                        matchResult.range.first,
                        matchResult.range.last,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }

                ArticleDetailTag.BOLD_TAG_REGEX.findAll(articleBody).forEach { matchResult ->
                    setSpan(
                        StyleSpan(Typeface.BOLD),
                        matchResult.range.first,
                        matchResult.range.last,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }

                ArticleDetailTag.CLICK_TAG_REGEX.findAll(articleBody).forEach { matchResult ->
                    setSpan(
                        clickableSpan,
                        matchResult.range.first,
                        matchResult.range.last,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }

            }

            ArticleDetailTag.REPLACE_STYLE_START_TAG_REGEX.findAll(spannable).forEach { matchResult ->
                spannable.delete(matchResult.range.first, matchResult.range.last + 1)
            }

            ArticleDetailTag.REPLACE_STYLE_END_TAG_REGEX.findAll(spannable).forEach { matchResult ->
                spannable.delete(matchResult.range.first, matchResult.range.last + 1)
            }

            binding.tvItemArticleDetailArticleBody.text = spannable
        }
    }

    class ItemArticleDetailArticleTitleViewHolder(private val binding: ItemArticleDetailArticleTitleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ArticleDetailData) {
            var articleTitle = data.body.replace(ArticleDetailTag.REPLACE_TAG_REGEX, "")
            binding.tvItemArticleDetailArticleTitle.text = articleTitle
        }

    }

    class ItemArticleDetailArticleImageViewHolder(private val binding: ItemArticleDetailArticleImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ArticleDetailData) {
            var articleImage = data.body.replace(ArticleDetailTag.REPLACE_TAG_REGEX, "")
            binding.ivItemArticleDetailArticleImage.load(articleImage)
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