package com.indipage.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

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
