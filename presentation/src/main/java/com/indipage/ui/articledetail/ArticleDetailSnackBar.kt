package com.indipage.ui.articledetail

import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.indipage.presentation.R
import com.indipage.presentation.databinding.ArticleDetailSnackbarBinding


class ArticleDetailSnackBar(view: View) {

    companion object {

        fun make(view: View) = ArticleDetailSnackBar(view)
    }

    private val context = view.context
    private val snackbar = Snackbar.make(view, "", 1500)
    private val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout

    private val inflater = LayoutInflater.from(context)
    private val binding: ArticleDetailSnackbarBinding =
        DataBindingUtil.inflate(inflater, R.layout.article_detail_snackbar, null, false)

    init {
        initView()
    }

    private fun initView() {
        with(snackbarLayout) {
            removeAllViews()
            setPadding(0, 0, 0, 0)
            setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
            addView(binding.root, 0)
        }
    }

    fun show() {
        snackbar.show()
    }

}