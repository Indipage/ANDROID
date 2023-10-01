package com.indipage.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.indipage.ui.signin.SignInActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
         * 듀토리얼 확인
         * 로그인 확인
         * 귀찮아 죽겠다
         * **/
        startActivity(Intent(this, SignInActivity::class.java))
        finish()
    }
}