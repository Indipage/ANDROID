package com.indipage.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core_ui.view.ItemDiffCallback
import com.indipage.data.dto.response.TestRecyclerviewImage
import com.indipage.databinding.ItemTestBinding

class TestRecyclerviewPagingAdapter(
) : PagingDataAdapter<TestRecyclerviewImage, TestRecyclerviewPagingAdapter.PagingViewHolder>(
    TestDiffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        val binding =
          ItemTestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class PagingViewHolder(private val binding: ItemTestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TestRecyclerviewImage) {
            binding.test = data
            binding.executePendingBindings()
        }
    }

    companion object {
        private val TestDiffCallback =
            ItemDiffCallback<TestRecyclerviewImage>(
                onItemsTheSame = { old, new -> old.id == new.id },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}
