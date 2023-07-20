package com.indipage.presentation.ticket

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
import com.example.core_ui.fragment.colorOf
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
    private val viewModel by viewModels<TicketViewModel>()
    private var testNum=0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initView()
        openQR()
        moveToCard()
        getCollectQrScanData()
    }

    override fun onResume() {
        super.onResume()
        binding.switchTicket.isChecked = false
        val color=colorOf(R.color.indi_white)
        binding.tvTicketSwitchTicket.setTextColor(color)
    }
    private fun initView() {
        viewModel.ticket.flowWithLifecycle(lifecycle).onEach {
            when (it) {

                is UiState.Success -> {
                    binding.progressBar.visibility=View.GONE
                    adapter.submitList(it.data)
                    binding.coTicketEmptyView.visibility = if (it.data.isEmpty()) View.VISIBLE else View.GONE
                }
                else -> {}
            }
        }.launchIn(lifecycleScope)
        binding.switchTicket.isChecked = false
    }

    private fun initAdapter() {
        adapter = TicketAdapter()
        binding.rvTicketTicket.adapter = adapter
        val itemTouchHelper = ItemTouchHelper(TicketItemHelper(viewModel))
        itemTouchHelper.attachToRecyclerView(binding.rvTicketTicket)
    }

    private fun openQR() {
        viewModel.openQrEvent.observe(viewLifecycleOwner, EventObserver {
            testNum=it
            onCustomScanButtonClicked()
        })
    }

    private fun moveToCard() {
        binding.switchTicket.setOnClickListener {
                if (binding.switchTicket.isChecked)
                    Handler().postDelayed({
                        findNavController()
                            .navigate(R.id.action_navigation_ticket_to_navigation_card, bundleOf())
                    }, 100)
                else Timber.d("test")
        }

    }

    private fun getCollectQrScanData() {
        viewModel.qrResponseCode.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    Timber.d("${it.data},$it")
                    when (it.data) {
                        200 -> {
                            Timber.d("Success QR")
                            Handler().postDelayed({
                                findNavController().navigate(
                                    R.id.action_navigation_ticket_to_qr_success,
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

    private val barcodeLauncher = registerForActivityResult(
        ScanContract()
    ) { result: ScanIntentResult ->
        if (result.contents != null) {
            Timber.tag("QR TEST").d(result.contents)
            Timber.tag("QR TEST 2").d("$testNum")
            if (result.contents.contains("http://3.37.34.144")) {
                val url = result.contents
                val regex = Regex(""".*(/(\d+)/).*""")
                val finalResult = regex.replace(url, "$2")
                if (testNum==finalResult.toInt()) viewModel.isCheckQR(finalResult.toInt())
                else toast("이티켓에 대한 큐알이 아니다.")
            } else {
                toast("다시 시도해라")
            }
        }
    }

    private fun onCustomScanButtonClicked() {
        val options = ScanOptions()
        options.setOrientationLocked(false)
        options.setBeepEnabled(true)
        options.setPrompt("커스텀 QR 스캐너 창")
        options.setDesiredBarcodeFormats(ScanOptions.QR_CODE)
        options.captureActivity = QrScanActivity::class.java
        barcodeLauncher.launch(options)
    }

    override fun onCheckDialogResult() {
        onCustomScanButtonClicked()
    }
}