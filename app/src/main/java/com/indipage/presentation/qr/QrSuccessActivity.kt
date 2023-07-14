package com.indipage.presentation.qr

import android.os.Bundle
import com.example.core_ui.base.BindingActivity
import com.indipage.R
import com.indipage.databinding.FragmentQrSuccessBinding
import timber.log.Timber

class QrSuccessActivity : BindingActivity<FragmentQrSuccessBinding>(R.layout.fragment_qr_success) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun initView() {
        Timber.d("initview")
    }
}