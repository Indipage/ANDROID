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
import android.view.View
import android.widget.Toast
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

        private val clickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                Toast.makeText(view.context, "문학 칵테일 클릭 이벤트", Toast.LENGTH_SHORT).show()
                view.findNavController().navigate(R.id.action_article_detail_to_space_detail)
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

            ArticleDetailTag.REPLACE_STYLE_START_TAG_REGEX.findAll(spannable)
                .forEach { matchResult ->
                    spannable.delete(matchResult.range.first, matchResult.range.last + 1)
                }

            ArticleDetailTag.REPLACE_STYLE_END_TAG_REGEX.findAll(spannable).forEach { matchResult ->
                spannable.delete(matchResult.range.first, matchResult.range.last + 1)
            }

            binding.tvItemArticleDetailArticleBody.text = spannable
            binding.tvItemArticleDetailArticleBody.setLineSpacing(24f,1f)
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

}