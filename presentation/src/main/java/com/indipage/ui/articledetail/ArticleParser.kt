package com.indipage.ui.articledetail

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.indipage.presentation.R
import com.indipage.util.ArticleDetailTag
import timber.log.Timber

class ArticleParser {
    fun splitArticleContent(input: String, spaceId: Long): List<ArticleDetailData> {
        var currentIndex = 0
        val articleList = mutableListOf<ArticleDetailData>()

        ArticleDetailTag.TAG_REGEX.findAll(input).forEach { matchResult ->

            val tagLessPart = input.substring(currentIndex, matchResult.range.first)

            if (tagLessPart.isNotBlank()) {
                articleList.add(ArticleDetailData(tagLessPart, spaceId))
            }

            articleList.add(ArticleDetailData(matchResult.value, spaceId))
            currentIndex = matchResult.range.last + 1
        }

        Timber.tag("split").d(articleList.toString())
        return articleList
    }

    fun getArticleContent(content: List<ArticleDetailData>): List<ArticleDetailParsing> {
        val parsingList = mutableListOf<ArticleDetailParsing>()
        for (i in content.indices) {
            val spaceId = content[i].spaceId
            when (getArticleContentType(content[i])) {
                ArticleDetailTag.TITLE -> {
                    val articleTitle =
                        content[i].body.replace(ArticleDetailTag.REPLACE_TAG_REGEX, "")
                    parsingList.add(ArticleDetailParsing(articleTitle, null, null, false, spaceId))
                }

                ArticleDetailTag.IMAGE -> {
                    val articleImage =
                        content[i].body.replace(ArticleDetailTag.REPLACE_TAG_REGEX, "")
                    parsingList.add(ArticleDetailParsing(null, articleImage, null, false, spaceId))
                }

                ArticleDetailTag.LINE -> {
                    parsingList.add(ArticleDetailParsing(null, null, null, true, spaceId))
                }

                else -> {
                    val articleBody =
                        content[i].body.replace(ArticleDetailTag.REPLACE_TAG_REGEX, "")
                    parsingList.add(
                        ArticleDetailParsing(
                            null, null, getSpannableString(articleBody, spaceId), false, spaceId
                        )
                    )
                }
            }
        }

        Timber.tag("parsing").d(parsingList.toString())
        return parsingList
    }

    private fun getArticleContentType(content: ArticleDetailData): Int {
        return when {
            content.body.contains(ArticleDetailTag.TITLE_TAG_REGEX) -> ArticleDetailTag.TITLE
            content.body.contains(ArticleDetailTag.IMAGE_TAG_REGEX) -> ArticleDetailTag.IMAGE
            content.body.contains(ArticleDetailTag.LINE_TAG_REGEX) -> ArticleDetailTag.LINE
            else -> ArticleDetailTag.BODY
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun getSpannableString(content: String, spaceId: Long): SpannableStringBuilder {
        val spannable = SpannableStringBuilder(content).apply {
            ArticleDetailTag.COLOR_TAG_REGEX.findAll(content).forEach { matchResult ->
                setSpan(
                    ForegroundColorSpan(R.color.indi_purple),
                    matchResult.range.first,
                    matchResult.range.last,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }

            ArticleDetailTag.BOLD_TAG_REGEX.findAll(content).forEach { matchResult ->
                setSpan(
                    StyleSpan(Typeface.BOLD),
                    matchResult.range.first,
                    matchResult.range.last,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }

            ArticleDetailTag.LINK_TAG_REGEX.findAll(content).forEach { matchResult ->
                setSpan(
                    clickableSpan(spaceId),
                    matchResult.range.first,
                    matchResult.range.last,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                setSpan(
                    ForegroundColorSpan(R.color.indi_purple),
                    matchResult.range.first,
                    matchResult.range.last,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                setSpan(
                    StyleSpan(Typeface.BOLD),
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

        return spannable
    }

    private fun clickableSpan(spaceId: Long) = object : ClickableSpan() {
        override fun onClick(view: View) {
            view.findNavController().navigate(
                R.id.action_article_detail_to_space_detail, bundleOf("spaceId" to spaceId.toInt())
            )
        }

        override fun updateDrawState(ds: TextPaint) {
            ds.isUnderlineText = true
        }
    }
}