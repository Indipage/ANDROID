package com.indipage.presentation.articledetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.ResponseTicketReceiveCheckDto
import com.indipage.databinding.ItemArticleDetailBottomTicketBinding
import timber.log.Timber

class ArticleDetailBottomTicketAdapter(private val onClickTicketReceived: (ResponseTicketReceiveCheckDto) -> Unit = { _ -> }) :
    ListAdapter<ResponseTicketReceiveCheckDto, ArticleDetailBottomTicketAdapter.ArticleDetailBottomTicketViewHolder>(
        ArticleAllDiffCallback
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ArticleDetailBottomTicketViewHolder {
        val binding = ItemArticleDetailBottomTicketBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ArticleDetailBottomTicketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleDetailBottomTicketViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ArticleDetailBottomTicketViewHolder(
        private val binding: ItemArticleDetailBottomTicketBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ResponseTicketReceiveCheckDto) {
            with(binding) {
                ticketReceive = data
                if (data.hasReceivedTicket) {
                    ivItemArticleDetailBottomTicketImage.load(data.ticket.ticketForArticleImageUrl)
                    tvItemArticleDetailBottomTicketPush.visibility = View.INVISIBLE
                    Timber.d("티켓 받음")
                } else {
                    Timber.d("티켓 안 받음")
                }
                binding.ivItemArticleDetailBottomTicketImage.setOnClickListener {
                    onClickTicketReceived(data)
                }
                executePendingBindings()
            }
        }
    }

    companion object {
        private val ArticleAllDiffCallback = ItemDiffCallback<ResponseTicketReceiveCheckDto>(
            onItemsTheSame = { old, new -> old.ticket.id == new.ticket.id },
            onContentsTheSame = { old, new -> old == new })
    }
}