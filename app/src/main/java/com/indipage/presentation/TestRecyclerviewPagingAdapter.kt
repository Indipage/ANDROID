package com.indipage.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.indipage.data.dto.kakao.KaKaoImage
import com.indipage.databinding.ItemKakaoImageBinding
import com.indipage.util.DiffCallback

class TestRecyclerviewPagingAdapter(
) : PagingDataAdapter<KaKaoImage, TestRecyclerviewPagingAdapter.PagingViewHolder>(
    KaKaoDiffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        val binding =
            ItemKakaoImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class PagingViewHolder(private val binding: ItemKakaoImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: KaKaoImage) {
            binding.kakaoimage = data
            binding.executePendingBindings()
        }
    }

    companion object {
        private val KaKaoDiffCallback =
            DiffCallback<KaKaoImage>(id = { old, new -> old.collection == new.collection })
    }
}
