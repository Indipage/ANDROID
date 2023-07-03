package com.indipage.util.base

import android.os.Bundle
import android.view.MotionEvent
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.indipage.util.hideKeyboard

abstract class BindingActivity<T : ViewDataBinding>(
    @LayoutRes private val layoutRes: Int,
) : AppCompatActivity() {
    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding.lifecycleOwner = this
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        hideKeyboard()
        return super.dispatchTouchEvent(ev)
    }
}