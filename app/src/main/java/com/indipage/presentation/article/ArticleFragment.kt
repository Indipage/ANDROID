package com.indipage.presentation.article

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.databinding.FragmentArticleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleFragment : BindingFragment<FragmentArticleBinding>(R.layout.fragment_article) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivArticlePlaceImage.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_article_to_article_detail)
        })
    }
}