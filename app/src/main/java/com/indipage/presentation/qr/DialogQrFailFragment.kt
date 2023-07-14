package com.indipage.presentation.qr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.indipage.databinding.FragmentDialogQrFailBinding

interface CheckDialogListener {
    fun onCheckDialogResult()
}
class DialogQrFailFragment: DialogFragment() {

    private var listener: CheckDialogListener? = null
    private var _binding: FragmentDialogQrFailBinding? = null
    private val binding get() = _binding!!
    fun setCheckDialogListener(listener: CheckDialogListener) {
        this.listener = listener
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDialogQrFailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBtn()
    }

    private fun initBtn() {
        binding.btnQrFailExit.setOnClickListener {
            dismiss()
        }

        binding.btnQrFailRetry.setOnClickListener {
            listener?.onCheckDialogResult()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()

    }
}