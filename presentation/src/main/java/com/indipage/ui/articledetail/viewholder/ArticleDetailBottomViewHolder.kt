package com.indipage.ui.articledetail.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.indipage.domain.model.ArticleDetail
import com.indipage.presentation.databinding.ItemArticleDetailBottomBinding

class ArticleDetailBottomViewHolder(private val binding: ItemArticleDetailBottomBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: ArticleDetail) {
        with(binding) {
            articleDetail = data
            executePendingBindings()
        }
    }
}