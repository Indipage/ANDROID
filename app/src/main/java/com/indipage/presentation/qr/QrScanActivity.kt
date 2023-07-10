package com.indipage.presentation.qr

import android.os.Bundle
import com.example.core_ui.base.BindingActivity
import com.indipage.R
import com.indipage.databinding.ActivityQrScanBinding
import com.journeyapps.barcodescanner.CaptureManager
import com.journeyapps.barcodescanner.DecoratedBarcodeView
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class QrScanActivity : BindingActivity<ActivityQrScanBinding>(R.layout.activity_qr_scan) {

    private lateinit var captureManager: CaptureManager
    private lateinit var decoratedBarcodeView: DecoratedBarcodeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        decoratedBarcodeView = binding.decoratedBarcodeView // 커스텀 바코드 뷰

        captureManager = CaptureManager(this, decoratedBarcodeView)
        captureManager.initializeFromIntent(intent, savedInstanceState)
        captureManager.setShowMissingCameraPermissionDialog(
            true,
            "카메라 권한 요청"
        )    // 권한요청 다이얼로그
        captureManager.decode()        // decoding start
    }

    override fun initView() {
        Timber.d("init")
    }

    override fun onResume() {
        super.onResume()
        captureManager.onResume()
    }

    override fun onPause() {
        super.onPause()
        captureManager.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        captureManager.onDestroy()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        captureManager.onSaveInstanceState(outState)
    }

    // 카메라 권한을 요청
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        captureManager.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}