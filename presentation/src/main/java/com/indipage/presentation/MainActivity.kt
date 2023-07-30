package com.indipage.presentation

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.core_ui.base.BindingActivity
import com.indipage.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
//        installSplashScreen()
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