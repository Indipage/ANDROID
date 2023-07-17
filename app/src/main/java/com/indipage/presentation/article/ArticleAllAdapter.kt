package com.indipage.presentation.article

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.ResponseArticleAllDto
import com.indipage.databinding.ItemArticleAllBinding


class ArticleAllAdapter(
) : ListAdapter<ResponseArticleAllDto, ArticleAllAdapter.ArticleAllViewHolder>(
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

    class ArticleAllViewHolder(
        private val binding: ItemArticleAllBinding
    ) : ViewHolder(binding.root) {
        fun bind(data: ResponseArticleAllDto) {
            with(binding) {
                articleAll = data
                executePendingBindings()
                layoutArticleAllReadArticle.visibility =
                    if (data.ticketReceived) View.VISIBLE else View.GONE
                layoutArticleAllNoReadArticle.visibility =
                    if (data.ticketReceived) View.GONE else View.VISIBLE
            }

        }
    }

    companion object {
        private val ArticleAllDiffCallback =
            ItemDiffCallback<ResponseArticleAllDto>(
                onItemsTheSame = { old, new -> old.spaceName == new.spaceName },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}