package com.indipage.presentation.article

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.ResponseArticleAllDto
import com.indipage.databinding.ItemArticleAllBinding


class ArticleAllAdapter(private val viewModel: ArticleViewModel) :
    ListAdapter<ResponseArticleAllDto, ArticleAllAdapter.ArticleAllViewHolder>(
        ArticleAllDiffCallback
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleAllViewHolder {
        val binding =
            ItemArticleAllBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleAllViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: ArticleAllViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ArticleAllViewHolder(
        private val binding: ItemArticleAllBinding, private val model: ArticleViewModel
    ) : ViewHolder(binding.root) {
        fun bind(data: ResponseArticleAllDto) {
            with(binding) {
                articleAll = data
                executePendingBindings()
                binding.viewModel = model
                if (data.ticketReceived) {
                    layoutArticleAllReadArticle.visibility = View.VISIBLE
                    layoutArticleAllNoReadArticle.visibility = View.GONE
                } else {
                    layoutArticleAllReadArticle.visibility = View.GONE
                    layoutArticleAllNoReadArticle.visibility = View.VISIBLE
                }
            }
        }
    }

    companion object {
        private val ArticleAllDiffCallback =
            ItemDiffCallback<ResponseArticleAllDto>(onItemsTheSame = { old, new -> old.spaceName == new.spaceName },
                onContentsTheSame = { old, new -> old == new })
    }
}