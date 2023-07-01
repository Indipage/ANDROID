package com.indipage.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.indipage.databinding.ActivityMainBinding
import com.indipage.util.pagingSubmitData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter = SearchPagingAdapter()
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner=this
        binding.rvKakaoSearchResult.adapter = adapter.apply {
            pagingSubmitData(this@MainActivity, viewModel.getKaKaoResult("1"), adapter)
        }
    }
}

