package com.indipage.ui.signin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.core_ui.base.BindingActivity
import com.example.core_ui.view.UiState
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.indipage.presentation.R
import com.indipage.presentation.databinding.ActivitySignInBinding
import com.indipage.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber


@AndroidEntryPoint
class SignInActivity : BindingActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {

    private lateinit var googleSignResultLauncher: ActivityResultLauncher<Intent>
    private val viewModel by viewModels<SignInViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        collectToken()
    }


    override fun initView() {
        getGoogleClient()
        googleSignResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            Timber.tag("resultCode").d("${result.resultCode}")
            val task: Task<GoogleSignInAccount> =
                GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleSignInResult(task)
        }
    }

    private fun getGoogleClient() {
        binding.tvSignInGoogleLogin.setOnClickListener {
            val googleSignInOption =
                GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .requestServerAuthCode("165711899943-akm9qai3cocq7k2ndpj85v2qlr0n6lja.apps.googleusercontent.com")
                    .requestIdToken("165711899943-akm9qai3cocq7k2ndpj85v2qlr0n6lja.apps.googleusercontent.com")
                    .build()
            val mGoogleSignInClient = GoogleSignIn.getClient(this, googleSignInOption)

            var signIntent: Intent = mGoogleSignInClient.signInIntent
            googleSignResultLauncher.launch(signIntent)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            var googleTokenAuth = account?.idToken.toString()
            Timber.tag("googleTokenAuth").d(googleTokenAuth)
            if (!googleTokenAuth.isNullOrBlank()) {
                viewModel.postGoogleLogin(googleTokenAuth)
            }
        } catch (e: ApiException) {
            Timber.d("signInResult:failed Code = " + e.statusCode)
        }
    }
    private fun collectToken() {
        viewModel.jwtToken.flowWithLifecycle(lifecycle).onEach {
            Timber.d("JwtToken Flow: $it")
            when (it) {
                is UiState.Success -> {
                    Timber.d(it.data.accessToken)
                    Timber.tag("check").d(it.data.accessToken)
                    viewModel.saveToken(it.data.accessToken)
                    navigateTo<MainActivity>()
                }

                else -> {}
            }
        }.launchIn(lifecycleScope)
    }

    private inline fun <reified T : Activity> navigateTo() {
        Intent(this@SignInActivity, T::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
        }
    }

}