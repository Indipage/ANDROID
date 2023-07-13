package com.indipage.presentation.ticket

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.databinding.FragmentTicketBinding
import com.indipage.presentation.qr.QrScanActivity
import com.indipage.util.EventObserver
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class TicketFragment : BindingFragment<FragmentTicketBinding>(R.layout.fragment_ticket) {

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

        viewModel.openProductEvent.observe(viewLifecycleOwner, EventObserver {
            setNavigationQR()
        })

        binding.switchTicket.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) findNavController().navigate(
                R.id.action_navigation_ticket_to_navigation_card, bundleOf(
                )
            )
            else Timber.d("test")
        }
    }

    private fun setNavigationQR() {

        onCustomScanButtonClicked()
    }

    private val barcodeLauncher = registerForActivityResult(
        ScanContract()
    ) { result: ScanIntentResult ->
        // result : 스캔된 결과

        // 내용이 없다면
        if (result.contents == null) {
        }
        else { // 내용이 있다면
            Timber.d(result.contents)
            val url = result.contents
            val regex = Regex(""".*(/(\d+)/).*""")
            val finalResult = regex.replace(url, "$2")
            viewModel.isCheckQR(finalResult.toInt())
        }
    }

    // 커스텀 스캐너 실행하기
    // Custom SCAN - onClick
    private fun onCustomScanButtonClicked() {
        val options = ScanOptions()
        options.setOrientationLocked(false)
        // options.setCameraId(1)          // 0 : 후면(default), 1 : 전면,
        options.setBeepEnabled(true)
        // options.setTorchEnabled(true)      // true : 실행되자마자 플래시가 켜진다.
        options.setPrompt("커스텀 QR 스캐너 창")
        options.setDesiredBarcodeFormats( ScanOptions.QR_CODE )
        options.captureActivity = QrScanActivity::class.java

        barcodeLauncher.launch(options)
    }
}