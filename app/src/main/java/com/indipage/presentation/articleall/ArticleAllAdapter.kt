package com.indipage.presentation.articleall

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.ResponseArticleAllDto
import com.indipage.databinding.ItemArticleAllBinding


class ArticleAllAdapter(
    private val onMoveToArticleDetailClick: (ResponseArticleAllDto, Int) -> Unit = { _, _ -> }) :
    ListAdapter<ResponseArticleAllDto, ArticleAllAdapter.ArticleAllViewHolder>(
        ArticleAllDiffCallback
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleAllViewHolder {
        val binding =
            ItemArticleAllBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleAllViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleAllViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ArticleAllViewHolder(
        private val binding: ItemArticleAllBinding
    ) : ViewHolder(binding.root) {
        fun bind(data: ResponseArticleAllDto) {
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
                    onMoveToArticleDetailClick(data,position)
                }
                executePendingBindings()
            }
        }
    }

    companion object {
        private val ArticleAllDiffCallback =
            ItemDiffCallback<ResponseArticleAllDto>(onItemsTheSame = { old, new -> old.spaceName == new.spaceName },
                onContentsTheSame = { old, new -> old == new })
    }
}