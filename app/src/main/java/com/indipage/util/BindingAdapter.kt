package com.indipage.util

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.indipage.R

@BindingAdapter("onThrottleClick", "clickInterval", requireAll = false)
fun applyThrottleClick(view: View, listener: View.OnClickListener, interval: Long? = 300L) {
    val throttleListener = interval?.let { time ->
        OnThrottleClickListener(listener, time)
    } ?: OnThrottleClickListener(listener)
    view.setOnClickListener(throttleListener)
}
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String) {
    view.load(url)
}

@BindingAdapter("setCircleImage")
fun ImageView.setCircleImage(img: String?) {
    load(img) {
        transformations(RoundedCornersTransformation(1000f))
    }
}

@BindingAdapter("operationInformation")
fun applyOperationFormat(view: TextView, item: String?) {
    val spaceInforFormat = "운영시간|$item" ?:"/"
    view.text = spaceInforFormat
}