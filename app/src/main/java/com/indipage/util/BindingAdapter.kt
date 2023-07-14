package com.indipage.util

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation

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
    val spaceInforFormat = "운영시간 | ${item}"
    view.text = spaceInforFormat
}


@BindingAdapter("closedInformation")
fun applyClosedFormat(view: TextView, item: String?) {
    val spaceInforFormat = "휴무 | ${item}"
    view.text = spaceInforFormat
}


@BindingAdapter("addressInformation")
fun applyAFormat(view: TextView, item: String?) {
    val spaceInforFormat = "주소 | ${item}"
    view.text = spaceInforFormat
}