package com.indipage.util

import android.util.Log
import android.view.View
import timber.log.Timber

class OnThrottleClickListener(
    private val clickListener: View.OnClickListener,
    private val interval: Long = 300L,
) : View.OnClickListener {

    private var clicked = false
    override fun onClick(v: View?) {
        if (!clicked) {
            clicked = true
            v?.run {
                postDelayed(
                    { clicked = false },
                    interval,
                )
                clickListener.onClick(v)
            }
        } else {
            Timber.d( "OnThrottleClickListener_onClick: miss!!")
        }
    }
}
