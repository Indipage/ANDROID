package com.indipage.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.core_ui.base.BindingActivity
import com.example.core_ui.context.longToast
import com.indipage.R
import com.indipage.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    // 어댑터 초기화
    private val adapter = TestRecyclerviewPagingAdapter()

    // ViewModel 초기화
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        longToast("test")
        /**
         *  viewModel.test(RequestTestDto("test123","test123"))
         *
         * **/

        /**
         *          리사이클러뷰 방출
         *
         *          binding.rvtest.adapter = adapter.apply {
         *          pagingSubmitData(this@MainActivity,viewModel.getRecyclerviewTest("1"),adapter)
         *          }
         *
         *          paging 라이브러리 사용해서 무한스크롤 리사이클러뷰 구현
         *          pagingSubmitData라는 유틸 함수를 만들어 놓았음
         * **/

        initView()
    }


    override fun initView() {
        val navController =
            supportFragmentManager.findFragmentById(R.id.fc_main)?.findNavController()

        with(binding) {
            botNavMain.itemIconTintList = null
            navController?.let { NavController ->
                botNavMain.setupWithNavController(NavController)
            }
        }

    }
}

