package com.indipage.presentation

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
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
        setBottomVisible(navController)

    }

    private fun setBottomVisible(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.botNavMain.visibility = if (destination.id in listOf(
                    R.id.navigation_article,
                    R.id.navigation_ticket,
                    R.id.navigation_search,
                    R.id.navigation_card,
                    R.id.navigation_my_page
                )
            ) View.VISIBLE else View.GONE
        }
    }
}