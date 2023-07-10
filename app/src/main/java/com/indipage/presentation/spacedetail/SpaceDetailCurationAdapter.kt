package org.android.go.sopt.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indipage.databinding.ItemSpaceDetailCurationBinding


class SpaceDetailCurationAdapter(_itemList: List<Int> = listOf()) :RecyclerView.Adapter<SpaceDetailCurationAdapter.PagerViewHolder>()
    {
        lateinit var binding: ItemSpaceDetailCurationBinding
        private var itemList: List<Int> = _itemList

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
            binding = ItemSpaceDetailCurationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return PagerViewHolder(binding)
        }

        class PagerViewHolder(val binding: ItemSpaceDetailCurationBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(src: Int) {
                binding.ivCuration.setImageResource(src)
            }
        }

        override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
            holder.bind(itemList[position])
        }

        override fun getItemCount() = itemList.size

        fun setItemList(itemList: List<Int>) {
            this.itemList = itemList
            notifyDataSetChanged()
        }
    }