//package com.indipage.presentation.spacedetail
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView.ViewHolder
//import com.indipage.data.dto.response.MockCurationData
//import com.indipage.databinding.ItemSpaceDetailCurationBinding
//import com.indipage.databinding.ItemSpaceDetailCurationInfoBinding
//
//
//class SpaceDetailCurationAdapter2() :
//    ListAdapter<MockCurationData, ViewHolder>(
//        SpaceDetailDiffCallback()
//    ) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
//        when (viewType) {
//            0 -> CurationViewHolder(
//                ItemSpaceDetailCurationBinding.inflate(
//                    LayoutInflater.from(parent.context), parent, false
//                )
//            )
//
//            else -> CurationInfoViewHolder(
//                ItemSpaceDetailCurationInfoBinding.inflate(
//                    LayoutInflater.from(parent.context), parent, false
//                )
//            )
//        }
//
//    override fun onBindViewHolder(
//        holder: ViewHolder, position: Int
//    ) {
//        val content = currentList[position]
//        when (holder) {
//            is CurationViewHolder -> holder.onBind(content)
//            is CurationInfoViewHolder -> holder.onBind(content)
//        }
//    }
//
//    class CurationViewHolder(
//        val binding: ItemSpaceDetailCurationBinding,
//    ) : ViewHolder(binding.root) {
//        fun onBind(data: MockCurationData) {
//            binding.curation = data
//        }
//    }
//
//    class CurationInfoViewHolder(
//        val binding: ItemSpaceDetailCurationInfoBinding,
//    ) : ViewHolder(binding.root) {
//        fun onBind(data: MockCurationData) {
//
//            binding.curation = data
//        }
//    }
//}
//
//class SpaceDetailDiffCallback : DiffUtil.ItemCallback<MockCurationData>() {
//    override fun areItemsTheSame(
//        oldItem: MockCurationData,
//        newItem: MockCurationData
//    ): Boolean {
//        return oldItem.bookData == newItem.bookData
//    }
//
//    override fun areContentsTheSame(
//        oldItem: MockCurationData,
//        newItem: MockCurationData
//    ): Boolean {
//        return oldItem == newItem
//    }
//}