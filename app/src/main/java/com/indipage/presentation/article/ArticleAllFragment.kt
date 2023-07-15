package com.indipage.presentation.article

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.databinding.FragmentArticleAllBinding

class ArticleAllFragment :
    BindingFragment<FragmentArticleAllBinding>(R.layout.fragment_article_all) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnArticleAllCategoryAll.isSelected = true
        setClickEventOnCategoryButton()
    }

    private fun setClickEventOnCategoryButton() {

        binding.btnArticleAllCategoryWeekly.setOnClickListener(View.OnClickListener {
            binding.btnArticleAllCategoryWeekly.isSelected =
                !binding.btnArticleAllCategoryWeekly.isSelected
            binding.btnArticleAllCategoryAll.isSelected =
                !binding.btnArticleAllCategoryAll.isSelected
            findNavController().navigate(R.id.action_article_all_to_article)
        })
    }
}