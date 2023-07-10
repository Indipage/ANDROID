package com.indipage.presentation.spacedetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indipage.databinding.ItemSpaceDetailTagBinding

class SpaceDetailTagAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var itemList = listOf<String>("안녕", "만나서", "반가워")


    class SpaceDetailTagViewHolder(private val binding: ItemSpaceDetailTagBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: String) = with(binding) {
            tvSpaceDetailTag.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ItemSpaceDetailTagBinding =
            ItemSpaceDetailTagBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return SpaceDetailTagViewHolder(binding)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as SpaceDetailTagViewHolder
        holder.onBind(itemList[position])
    }
}