package com.indipage.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.indipage.data.dto.request.RequestSignInDto
import com.indipage.databinding.ActivityMainBinding
import com.indipage.util.pagingSubmitData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter = TestRecyclerviewPagingAdapter()
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner=this

        viewModel.signIn(RequestSignInDto("test123","test1234"))
        binding.rvKakaoSearchResult.adapter = adapter.apply {
            pagingSubmitData(this@MainActivity, viewModel.getRecyclerviewTest("1"), adapter)
        }
    }
}

