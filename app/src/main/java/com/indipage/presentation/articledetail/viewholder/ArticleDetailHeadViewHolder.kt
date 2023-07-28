package com.indipage.presentation.articledetail.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.indipage.databinding.ItemArticleDetailHeadBinding
import com.indipage.domain.entity.ArticleDetail

class ArticleDetailHeadViewHolder(
    private val binding: ItemArticleDetailHeadBinding,
    private val onMoveToSpaceDetailClick: (ArticleDetail, Int) -> Unit = { _, _ -> }
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: ArticleDetail) {
        with(binding) {
            binding.articleDetail = data
            binding.tvItemArticleDetailHeadMoveToPlaceDetail1.setOnClickListener {
                onMoveToSpaceDetailClick(
                    data, position
                )
            }
            tvItemArticleDetailHeadMoveToPlaceDetail2.setOnClickListener {
                onMoveToSpaceDetailClick(
                    data, position
                )
            }
        }
        binding.executePendingBindings()
    }
}