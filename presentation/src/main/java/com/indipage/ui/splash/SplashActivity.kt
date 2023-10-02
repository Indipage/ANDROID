package com.indipage.ui.splash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.indipage.ui.MainActivity
import com.indipage.ui.signin.SignInActivity
import com.indipage.ui.signin.SignInViewModel
import com.indipage.ui.tutorial.TutorialActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<SignInViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (mainViewModel.getFirst()) {
            Timber.d("${mainViewModel.getCheckLogin()}")
            if (mainViewModel.getCheckLogin()) {
                navigateTo<MainActivity>()
            } else {
                navigateTo<SignInActivity>()
            }
        } else {
            mainViewModel.saveFirst(true)
            navigateTo<TutorialActivity>()
        }
    }

    private inline fun <reified T : Activity> navigateTo() {
        Intent(this@SplashActivity, T::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
            finish()
        }
    }
}