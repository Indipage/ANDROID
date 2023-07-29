package com.indipage.presentation.articledetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.databinding.ItemArticleDetailBottomTicketBinding
import com.indipage.domain.model.TicketReceiveCheck
import com.indipage.presentation.articledetail.viewholder.ArticleDetailBottomTicketViewHolder

class ArticleDetailBottomTicketAdapter(private val onClickTicketReceived: (TicketReceiveCheck) -> Unit = { _ -> }) :
    ListAdapter<TicketReceiveCheck, ArticleDetailBottomTicketViewHolder>(
        ArticleAllDiffCallback
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ArticleDetailBottomTicketViewHolder {
        val binding = ItemArticleDetailBottomTicketBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ArticleDetailBottomTicketViewHolder(binding, onClickTicketReceived)
    }

    override fun onBindViewHolder(holder: ArticleDetailBottomTicketViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val ArticleAllDiffCallback = ItemDiffCallback<TicketReceiveCheck>(
            onItemsTheSame = { old, new -> old.ticket.id == new.ticket.id },
            onContentsTheSame = { old, new -> old == new })
    }
}