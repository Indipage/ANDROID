package com.indipage.presentation.articledetail.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.indipage.databinding.ItemArticleDetailBottomBinding
import com.indipage.domain.model.ArticleDetail

class ArticleDetailBottomViewHolder(private val binding: ItemArticleDetailBottomBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: ArticleDetail) {
        with(binding) {
            articleDetail = data
            executePendingBindings()
        }
    }
}