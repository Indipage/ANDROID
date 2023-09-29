package com.indipage.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.core_ui.base.BindingActivity
import com.example.core_ui.context.longToast
import com.example.core_ui.view.UiState
import com.indipage.presentation.R
import com.indipage.presentation.databinding.ActivityMainBinding
import com.indipage.ui.signin.SignInActivity
import com.indipage.ui.signin.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel by viewModels<SignInViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setupLogoutState()
    }

    override fun initView() {
        val navController =
            supportFragmentManager.findFragmentById(R.id.fc_main)?.findNavController()!!

        with(binding) {
            botNavMain.itemIconTintList = null
            navController?.let { NavController ->
                botNavMain.setupWithNavController(NavController)
            }

        }

        setBottomVisible(navController)
    }

    private fun setupLogoutState() {
        mainViewModel.logoutState.flowWithLifecycle(lifecycle).onEach { state ->
            when (state) {
                is UiState.Loading -> {
                }

                is UiState.Success -> {
                    navigateToLoginScreen()
                    longToast("로그인이 필요합니다.")
                }

                is UiState.Failure -> {
                }

                is UiState.Empty -> {
                }
            }
        }.launchIn(lifecycleScope)
    }

    private fun navigateToLoginScreen() {
        Intent(this@MainActivity, SignInActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(this)
            finish()
        }
    }

    private fun setBottomVisible(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.botNavMain.visibility = if (destination.id in listOf(
                    R.id.navigation_article,
                    R.id.navigation_ticket,
                    R.id.navigation_search,
                    R.id.navigation_card,
                    R.id.navigation_my_page,
                    R.id.navigation_article_all
                )
            ) View.VISIBLE else View.GONE

            if (destination.id == R.id.navigation_article_all) {
                binding.botNavMain.menu.findItem(R.id.navigation_article).isChecked = true
            }
            if (destination.id == R.id.navigation_card) {
                binding.botNavMain.menu.findItem(R.id.navigation_ticket).isChecked = true
            }
            if (destination.id == R.id.navigation_ticket) {
                binding.botNavMain.menu.findItem(R.id.navigation_ticket).isChecked = true
            }
        }
    }
}