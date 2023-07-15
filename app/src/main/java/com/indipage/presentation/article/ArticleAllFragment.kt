package com.indipage.presentation.article

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.databinding.FragmentArticleAllBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleAllFragment :
    BindingFragment<FragmentArticleAllBinding>(R.layout.fragment_article_all) {

    private val viewModel by viewModels<ArticleAllViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.btnArticleAllCategoryAll.isSelected = true
        setClickEventOnCategoryButton()
        getData()
        observeArticleAll()
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

    private fun getData() {
        viewModel.getArticleAll()
    }

    private fun observeArticleAll() {
        viewModel.articleAllData.observe(viewLifecycleOwner) {
            binding.rvArticleAll.adapter = ArticleAllAdapter().apply {
                submitList(it)
            }
        }
    }
}