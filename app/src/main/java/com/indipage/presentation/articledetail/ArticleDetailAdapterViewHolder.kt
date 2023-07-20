package com.indipage.presentation.articledetail

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.indipage.R
import com.indipage.databinding.ItemArticleDetailArticleBodyBinding
import com.indipage.databinding.ItemArticleDetailArticleImageBinding
import com.indipage.databinding.ItemArticleDetailArticleTitleBinding
import com.indipage.util.ArticleDetailTag

class ArticleDetailAdapterViewHolder {

    class ItemArticleDetailArticleBodyViewHolder(private val binding: ItemArticleDetailArticleBodyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private fun clickableSpan(spaceId: Long) = object : ClickableSpan() {
            override fun onClick(view: View) {
                Toast.makeText(view.context, "문학 칵테일 클릭 이벤트", Toast.LENGTH_SHORT).show()
                view.findNavController().navigate(
                    R.id.action_article_detail_to_space_detail,
                    bundleOf("spaceId" to spaceId.toInt())
                )
            }

            override fun updateDrawState(ds: TextPaint) {
                ds.isUnderlineText = true
            }
        }

        @SuppressLint("ResourceAsColor")
        fun onBind(data: ArticleDetailData) {
            var articleBody = data.body

            binding.viewItemArticleDetailArticleBody.isVisible = false
            repeat(ArticleDetailTag.LINE_TAG_REGEX.findAll(articleBody).count()) {
                binding.viewItemArticleDetailArticleBody.isVisible = true
            }

            articleBody = articleBody.replace(ArticleDetailTag.REPLACE_TAG_REGEX, "")
            binding.tvItemArticleDetailArticleBody.movementMethod = LinkMovementMethod()


            val spannable = SpannableStringBuilder(articleBody).apply {
                ArticleDetailTag.COLOR_TAG_REGEX.findAll(articleBody).forEach { matchResult ->
                    setSpan(
                        ForegroundColorSpan(R.color.indi_purple),
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
                        clickableSpan(data.spaceId),
                        matchResult.range.first,
                        matchResult.range.last,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }

            }

            ArticleDetailTag.REPLACE_STYLE_START_TAG_REGEX.findAll(spannable)
                .forEach { matchResult ->
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
            val articleTitle = data.body.replace(ArticleDetailTag.REPLACE_TAG_REGEX, "")
            binding.tvItemArticleDetailArticleTitle.text = articleTitle
        }

    }

    class ItemArticleDetailArticleImageViewHolder(private val binding: ItemArticleDetailArticleImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ArticleDetailData) {
            val articleImage = data.body.replace(ArticleDetailTag.REPLACE_TAG_REGEX, "")
            binding.ivItemArticleDetailArticleImage.load(articleImage)
        }
    }
}