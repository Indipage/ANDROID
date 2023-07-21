package com.indipage.presentation.articledetail

import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.indipage.R
import com.indipage.databinding.ArticleDetailSnackbarBinding


class ArticleDetailSnackBar(view: View) {

    companion object {

        fun make(view: View) = ArticleDetailSnackBar(view)
    }

    private val context = view.context
    private val snackbar = Snackbar.make(view, "", 5000)
    private val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout

    private val inflater = LayoutInflater.from(context)
    private val binding: ArticleDetailSnackbarBinding =
        DataBindingUtil.inflate(inflater, R.layout.article_detail_snackbar, null, false)

    init {
        initView()
        initClickEventListeners()
    }

    private fun initView() {
        with(snackbarLayout) {
            removeAllViews()
            setPadding(0, 0, 0, 0)
            setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
            addView(binding.root, 0)
        }
    }

    private fun initClickEventListeners() {
        binding.root.setOnClickListener {

        }
    }

    fun show() {
        snackbar.show()
    }

}