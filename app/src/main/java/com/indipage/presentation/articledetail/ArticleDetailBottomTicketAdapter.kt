package com.indipage.presentation.articledetail

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.ResponseTicketReceiveCheckDto
import com.indipage.databinding.ItemArticleDetailBottomTicketBinding
import timber.log.Timber

class ArticleDetailBottomTicketAdapter(private val viewModel: ArticleDetailViewModel) :
    ListAdapter<ResponseTicketReceiveCheckDto, ArticleDetailBottomTicketAdapter.ArticleDetailBottomTicketViewHolder>(
        ArticleAllDiffCallback
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ArticleDetailBottomTicketViewHolder {
        val binding = ItemArticleDetailBottomTicketBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ArticleDetailBottomTicketViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: ArticleDetailBottomTicketViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ArticleDetailBottomTicketViewHolder(
        private val binding: ItemArticleDetailBottomTicketBinding,
        private val viewModel: ArticleDetailViewModel
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ResponseTicketReceiveCheckDto) {
            with(binding) {
                ticketReceive = data
                executePendingBindings()
                model = viewModel
                if (data.hasReceivedTicket) {
                    ivItemArticleDetailBottomTicketImage.load(data.ticket.ticketImageUrl)
                    Timber.d("티켓 받음")
                    Toast.makeText(binding.root.context, "티켓 받음", Toast.LENGTH_SHORT).show()
                } else {
                    Timber.d("티켓 안 받음")
                    Toast.makeText(binding.root.context, "티켓 안 받음", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    companion object {
        private val ArticleAllDiffCallback = ItemDiffCallback<ResponseTicketReceiveCheckDto>(
            onItemsTheSame = { old, new -> old.ticket.id == new.ticket.id },
            onContentsTheSame = { old, new -> old == new })
    }
}