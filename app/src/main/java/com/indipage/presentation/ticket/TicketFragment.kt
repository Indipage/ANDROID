package com.indipage.presentation.ticket

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.core_ui.base.BindingFragment
import com.example.core_ui.fragment.toast
import com.example.core_ui.view.UiState
import com.indipage.R
import com.indipage.databinding.FragmentTicketBinding
import com.indipage.presentation.qr.CheckDialogListener
import com.indipage.presentation.qr.DialogQrFailFragment
import com.indipage.presentation.qr.QrScanActivity
import com.indipage.util.EventObserver
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class TicketFragment : BindingFragment<FragmentTicketBinding>(R.layout.fragment_ticket),
    CheckDialogListener {

    private lateinit var adapter: TicketAdapter
    private lateinit var adapter2: CardAdapter

    private val viewModel by viewModels<TicketViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TicketAdapter()
        adapter2 = CardAdapter()
        val spaceList = listOf(
            "https://avatars.githubusercontent.com/u/93514333?v=4",
            "https://avatars.githubusercontent.com/u/93514333?v=4",
            "https://avatars.githubusercontent.com/u/93514333?v=4",
        )
        binding.rvTicketTicket.adapter = adapter

        val itemTouchHelper = ItemTouchHelper(TicketItemHelper(viewModel))
        itemTouchHelper.attachToRecyclerView(binding.rvTicketTicket)

        binding.coTicketEmptyView.visibility = if (spaceList.isEmpty()) View.VISIBLE else View.GONE
        adapter.submitList(spaceList)
        openQR()
        moveToCard()
        getColletQRScanData()
    }

    private fun openQR() {
        viewModel.openProductEvent.observe(viewLifecycleOwner, EventObserver {
            setNavigationQR()
        })
    }

    private fun moveToCard() {
        binding.switchTicket.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                Handler().postDelayed({
                    findNavController().navigate(
                        R.id.action_navigation_ticket_to_navigation_card, bundleOf(
                        )
                    )
                }, 100)
            else Timber.d("test")
        }
    }

    private fun getColletQRScanData() {
        viewModel.qrResponseCode.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    Timber.d("${it.data},$it")
                    when (it.data) {
                        200 -> {
                            Timber.d("Success QR")
                            Handler().postDelayed({
                                findNavController().navigate(
                                    R.id.action_navigation_card_to_navigation_ticket,
                                    bundleOf()
                                )
                            }, 100)
                            viewModel.closeQR()
                        }
                        404 -> {
                            Timber.d("failure QR")
                            val dialog = DialogQrFailFragment()
                            dialog.setCheckDialogListener(this)
                            dialog.show(parentFragmentManager, "dialog")
                        }
                    }
                }
                else -> {}
            }
        }.launchIn(lifecycleScope)
    }
    private fun setNavigationQR() {
        onCustomScanButtonClicked()
    }
    private val barcodeLauncher = registerForActivityResult(
        ScanContract()
    ) { result: ScanIntentResult ->
        if (result.contents == null) {
        } else {
            Timber.d(result.contents)
            if (result.contents.contains("http://3.37.34.144")) {
                val url = result.contents
                val regex = Regex(""".*(/(\d+)/).*""")
                val finalResult = regex.replace(url, "$2")
                viewModel.isCheckQR(finalResult.toInt())
            } else {
                toast("다시 시도해라")
            }
        }
    }
    private fun onCustomScanButtonClicked() {
        val options = ScanOptions()
        options.setOrientationLocked(false)
        // options.setCameraId(1)          // 0 : 후면(default), 1 : 전면,
        options.setBeepEnabled(true)
        // options.setTorchEnabled(true)      // true : 실행되자마자 플래시가 켜진다.
        options.setPrompt("커스텀 QR 스캐너 창")
        options.setDesiredBarcodeFormats(ScanOptions.QR_CODE)
        options.captureActivity = QrScanActivity::class.java
        barcodeLauncher.launch(options)
    }
    override fun onCheckDialogResult() {
        setNavigationQR()
    }
}