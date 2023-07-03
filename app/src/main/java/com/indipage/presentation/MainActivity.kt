package com.indipage.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.indipage.data.dto.request.RequestTestDto
import com.indipage.databinding.ActivityMainBinding
import com.indipage.util.pagingSubmitData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    // 어댑터 초기화
    private val adapter = TestRecyclerviewPagingAdapter()
    // ViewModel 초기화
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        /**
         *  viewModel.test(RequestTestDto("test123"))
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

    }
}

