package com.indipage.presentation.search

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.core.os.bundleOf
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BindingFragment
import com.example.core_ui.view.UiState
import com.indipage.R
import com.indipage.databinding.FragmentSearchBinding
import com.indipage.domain.model.Search
import com.indipage.util.Debouncer
import com.indipage.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class SearchFragment : BindingFragment<FragmentSearchBinding>(R.layout.fragment_search) {

    private val viewModel by viewModels<SearchViewModel>()
    private lateinit var adapter: SearchAdapter
    private val searchDebouncer = Debouncer<String>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getSearchResult()
        initEditText()

        viewModel.openSpaceEvent.observe(viewLifecycleOwner, EventObserver {
            Timber.d("test $it")
            findNavController().navigate(
                R.id.action_navigation_search_to_navigation_space_detail, bundleOf(
                    "spaceId" to it.toInt()
                )
            )
        })
    }

    private fun getSearchResult() {
        viewModel.searchData.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    binding.coEmptySearch.visibility = if (it.data.isEmpty()) VISIBLE else GONE
                    initAdapter(it.data)
                }

                else -> {}
            }
        }.launchIn(lifecycleScope)
    }

    private fun initEditText() {
        Timber.d("검색 editText 설정")
        binding.etSearch.doAfterTextChanged { text ->
            Timber.d("검색 editText 텍스트 수정됨 / 키워드 = ${binding.etSearch.text}")
            val keyword: String? =
                if (binding.etSearch.text.toString() != "") binding.etSearch.text.toString() else null
            viewModel.getSearchResult(keyword)
            searchDebouncer.setDelay(text.toString(), 1000L) {
            }
        }
    }


    private fun initAdapter(data: List<Search>) {
        Timber.d("검색 리사이클러뷰 초기화")
        adapter = SearchAdapter(onMoveToSpaceDetailClick = { searchData, position ->
            viewModel.openSpaceDetail(searchData.spaceId.toLong())
        })
        binding.rvSearch.adapter = adapter.apply {
            submitList(data)
        }
    }
}