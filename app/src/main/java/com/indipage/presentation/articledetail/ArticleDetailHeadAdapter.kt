package com.indipage.presentation.articledetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.ResponseArticleDetailDto
import com.indipage.databinding.ItemArticleDetailHeadBinding

class ArticleDetailHeadAdapter(private val viewModel: ArticleDetailViewModel) :
    ListAdapter<ResponseArticleDetailDto, ArticleDetailHeadAdapter.ArticleDetailHeadViewHolder>(
        ArticleAllDiffCallback
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleDetailHeadViewHolder {
        val binding =
            ItemArticleDetailHeadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleDetailHeadViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: ArticleDetailHeadViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ArticleDetailHeadViewHolder(
        private val binding: ItemArticleDetailHeadBinding, private val model: ArticleDetailViewModel
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ResponseArticleDetailDto) {
            with(binding) {
                articleDetail = data
                executePendingBindings()
                binding.viewModel = model

            }
        }
    }

    companion object {
        private val ArticleAllDiffCallback = ItemDiffCallback<ResponseArticleDetailDto>(
            onItemsTheSame = { old, new -> old.id == new.id },
            onContentsTheSame = { old, new -> old == new })
    }
}