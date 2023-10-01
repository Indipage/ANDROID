package com.indipage.ui.splash

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
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else{
                startActivity(Intent(this, SignInActivity::class.java))
                finish()
            }
        } else {

            mainViewModel.saveFirst(true)
            startActivity(Intent(this, TutorialActivity::class.java))
            finish()
        }
        /*
         * 듀토리얼 확인
         * 로그인 확인
         * 귀찮아 죽겠다
         * **/

    }
}