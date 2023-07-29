package com.indipage.presentation.articleall.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.indipage.databinding.ItemArticleAllBinding
import com.indipage.domain.entity.ArticleAll

class ArticleAllViewHolder(
    private val binding: ItemArticleAllBinding,
    private val onMoveToArticleDetailClick: (ArticleAll, Int) -> Unit = { _, _ -> }
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: ArticleAll) {
        with(binding) {
            articleAll = data
            if (data.ticketReceived) {
                layoutArticleAllReadArticle.visibility = View.VISIBLE
                layoutArticleAllNoReadArticle.visibility = View.GONE
            } else {
                layoutArticleAllReadArticle.visibility = View.GONE
                layoutArticleAllNoReadArticle.visibility = View.VISIBLE
            }
            binding.root.setOnClickListener {
                onMoveToArticleDetailClick(data, position)
            }
            executePendingBindings()
        }
    }

}