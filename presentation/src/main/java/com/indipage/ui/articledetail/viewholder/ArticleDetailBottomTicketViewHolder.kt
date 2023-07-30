package com.indipage.ui.articledetail.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.indipage.domain.model.TicketReceiveCheck
import com.indipage.presentation.databinding.ItemArticleDetailBottomTicketBinding
import timber.log.Timber

class ArticleDetailBottomTicketViewHolder(
    private val binding: ItemArticleDetailBottomTicketBinding,
    private val onClickTicketReceived: (TicketReceiveCheck) -> Unit = { _ -> }
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(data: TicketReceiveCheck) {
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