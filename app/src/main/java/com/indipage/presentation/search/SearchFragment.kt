package com.indipage.presentation.search

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.core.widget.doAfterTextChanged
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.data.dto.response.Search
import com.indipage.databinding.FragmentSearchBinding
import com.indipage.util.Debouncer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BindingFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    private lateinit var adapter: SearchAdapter
    private val searchDebouncer = Debouncer<String>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SearchAdapter()
        val searchList = listOf(
            Search(
                imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
                searchTitle = "안녁아세요",
                searchComment = "하이하이 나는 안드임 클라이언트 짱짱맨"
            ),
            Search(
                imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
                searchTitle = "안녁아세요",
                searchComment = "하이하이 나는 안드임 클라이언트 짱짱맨"
            ),
            Search(
                imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
                searchTitle = "안녁아세요",
                searchComment = "하이하이 나는 안드임 클라이언트 짱짱맨"
            ),
            Search(
                imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
                searchTitle = "안녁아세요",
                searchComment = "하이하이 나는 안드임 클라이언트 짱짱맨"
            ),
            Search(
                imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
                searchTitle = "안녁아세요",
                searchComment = "하이하이 나는 안드임 클라이언트 짱짱맨"
            ),
            Search(
                imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
                searchTitle = "안녁아세요",
                searchComment = "하이하이 나는 안드임 클라이언트 짱짱맨"
            ),
        )
        binding.rvSearch.adapter = adapter
        adapter.submitList(searchList)
    }

    private fun initEditText() {
        binding.etSearch.setOnKeyListener { _, keyCode, event ->
            var handled = false
            if ((event.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                // 엔터가 눌리면
                initAdapter(binding.etSearch.text.toString())
                handled = true
            }
            handled
        }

        binding.etSearch.doAfterTextChanged { text ->
            searchDebouncer.setDelay(text.toString(), 500L) {
                initAdapter(binding.etSearch.text.toString())
            }
        }
    }

    private fun initAdapter(query: String) {
        binding.rvSearch.adapter = adapter
    }
}