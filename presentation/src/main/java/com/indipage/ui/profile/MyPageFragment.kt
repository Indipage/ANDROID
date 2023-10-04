package com.indipage.ui.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BindingFragment
import com.example.core_ui.view.UiState
import com.indipage.presentation.R
import com.indipage.presentation.databinding.FragmentMyPageBinding
import com.indipage.ui.signin.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber


@AndroidEntryPoint
class MyPageFragment : BindingFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {

    private val viewModel by viewModels<MyPageViewModel>()
    private val parentViewModel by activityViewModels<SignInViewModel>()
    override fun onStart() {
        super.onStart()
        parentViewModel.getUser()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        moveToSaveArticle()
        moveToSaveSpace()
        eventLogout()
        eventPrivacyPolicy()
        eventTermsOfUse()
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
                R.id.action_navigation_my_page_to_saved_space, bundleOf()
            )
        }
    }

    private fun eventLogout() {
        binding.tvMyPageProfileLogout.setOnClickListener {
            parentViewModel.postLogout()
        }
    }

    private fun eventPrivacyPolicy() {
        binding.tvMyPagePrivacyPolicy.setOnClickListener {
            val urlIntentPrivacyPolicy = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://pppclub.notion.site/00eb6c87ba8544669ca92a8ef53dce1c?pvs=4")
            )
            startActivity(urlIntentPrivacyPolicy)
        }
    }

    private fun eventTermsOfUse() {
        binding.tvMyPageTermsOfUse.setOnClickListener {
            val urlIntentTermsOfUse = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://pppclub.notion.site/966f09583d964587a6080ab12f293d78")
            )
            startActivity(urlIntentTermsOfUse)
        }
    }
}