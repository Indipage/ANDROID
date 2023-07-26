package com.indipage.presentation.articledetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.ResponseArticleDetailDto
import com.indipage.databinding.ItemArticleDetailHeadBinding
import com.indipage.domain.entity.Space

class ArticleDetailHeadAdapter(
    private val onMoveToSpaceDetailClick: (ResponseArticleDetailDto, Int) -> Unit = { _, _ -> }
) : ListAdapter<ResponseArticleDetailDto, ArticleDetailHeadAdapter.ArticleDetailHeadViewHolder>(
    ArticleAllDiffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleDetailHeadViewHolder {
        val binding =
            ItemArticleDetailHeadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleDetailHeadViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleDetailHeadViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ArticleDetailHeadViewHolder(
        private val binding: ItemArticleDetailHeadBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ResponseArticleDetailDto) {
            with(binding) {
                binding.articleDetail = data
                binding.tvItemArticleDetailHeadMoveToPlaceDetail1.setOnClickListener {
                    onMoveToSpaceDetailClick(
                        data,
                        position
                    )
                }
                tvItemArticleDetailHeadMoveToPlaceDetail2.setOnClickListener {
                    onMoveToSpaceDetailClick(
                        data,
                        position
                    )
                }
            }
            binding.executePendingBindings()
        }
    }

    companion object {
        private val ArticleAllDiffCallback = ItemDiffCallback<ResponseArticleDetailDto>(
            onItemsTheSame = { old, new -> old.id == new.id },
            onContentsTheSame = { old, new -> old == new })
    }
}