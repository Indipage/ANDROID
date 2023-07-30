package com.indipage.ui.ticket.ticket.itemhelper

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.indipage.ui.ticket.ticket.TicketAdapter
import com.indipage.ui.ticket.ticket.viewholder.TicketViewHolder

class TicketItemHelper(
    private val onOpenQr: (Int) -> Unit = { _ -> }
) : ItemTouchHelper.Callback() {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlags = ItemTouchHelper.LEFT
        return makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }

    override fun isLongPressDragEnabled(): Boolean {
        return false
    }

    override fun getSwipeEscapeVelocity(defaultValue: Float): Float {
        return defaultValue * 20
    }

    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder): Float {
        return 2f
    }

    override fun clearView(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
    ) {
        val position = viewHolder.adapterPosition
        val adapter = recyclerView.adapter as? TicketAdapter
        if (position != RecyclerView.NO_POSITION && adapter != null) {
            val item = adapter.currentList.getOrNull(position)
            item?.let {
                onOpenQr
            }
        }


        getDefaultUIUtil().clearView((viewHolder as TicketViewHolder).itemView)
    }

}