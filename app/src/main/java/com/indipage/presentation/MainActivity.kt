package com.indipage.presentation

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.core_ui.base.BindingActivity
import com.indipage.R
import com.indipage.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
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

    }
}