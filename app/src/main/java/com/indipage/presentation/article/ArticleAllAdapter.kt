package com.indipage.presentation.article

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.ResponseArticleAllDto
import com.indipage.databinding.ItemSavedArticleBinding


class ArticleAllAdapter(
) : ListAdapter<ResponseArticleAllDto, ArticleAllAdapter.ArticleAllViewHolder>(
    ArticleAllDiffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleAllViewHolder {
        val binding =
            ItemSavedArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleAllViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleAllViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ArticleAllViewHolder(
        private val binding: ItemSavedArticleBinding
    ) : ViewHolder(binding.root) {
        fun bind(data: ResponseArticleAllDto) {
            with(binding) {
                ivSavedArticleBackground.load(data.thumbnailUrl)
                tvSavedArticleSpace.text = data.spaceType
                tvSavedArticleName.text = data.spaceName
                tvSavedArticleComment.text = data.title
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