package com.indipage.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BindingFragment
import com.example.core_ui.view.UiState
import com.indipage.R
import com.indipage.databinding.FragmentMyPageBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class MyPageFragment : BindingFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {

    private val viewModel by viewModels<MyPageViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        moveToSaveArticle()
        moveToSaveSpace()
    }

    private fun initView() {
        getUserInfo()
    }

    private fun getUserInfo() {
        viewModel.userInfo.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    binding.userInfo = it.data
                    Timber.d(it.data.toString())
                }
                else -> {}
            }
        }.launchIn(lifecycleScope)
    }

    private fun moveToSaveSpace() {
        binding.clMyPageSavedView.setOnClickListener {
            findNavController().navigate(
                R.id.action_navigation_my_page_to_saved_article, bundleOf(
                )
            )
        }
    }

    private fun moveToSaveArticle() {
        binding.clMyPageSavedView2.setOnClickListener {
            findNavController().navigate(
                R.id.action_navigation_my_page_to_saved_space, bundleOf(
                )
            )
        }
    }


}