package com.indipage.presentation.articledetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.databinding.ItemArticleDetailHeadBinding
import com.indipage.domain.model.ArticleDetail
import com.indipage.presentation.articledetail.viewholder.ArticleDetailHeadViewHolder

class ArticleDetailHeadAdapter(
    private val onMoveToSpaceDetailClick: (ArticleDetail, Int) -> Unit = { _, _ -> }
) : ListAdapter<ArticleDetail, ArticleDetailHeadViewHolder>(
    ArticleAllDiffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleDetailHeadViewHolder {
        val binding =
            ItemArticleDetailHeadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleDetailHeadViewHolder(binding, onMoveToSpaceDetailClick)
    }

    override fun onBindViewHolder(holder: ArticleDetailHeadViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    companion object {
        private val ArticleAllDiffCallback = ItemDiffCallback<ArticleDetail>(
            onItemsTheSame = { old, new -> old.id == new.id },
            onContentsTheSame = { old, new -> old == new })
    }
}