package com.indipage.presentation.search

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import com.example.core_ui.base.BindingFragment
import com.indipage.R
import com.indipage.data.dto.response.ResponseSearchData.SearchDetailData
import com.indipage.databinding.FragmentSearchBinding
import com.indipage.util.Debouncer
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SearchFragment : BindingFragment<FragmentSearchBinding>(R.layout.fragment_search) {

    private val viewModel by viewModels<SearchViewModel>()
    private lateinit var adapter: SearchAdapter
    private val searchDebouncer = Debouncer<String>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initEditText()
    }

    private fun initAdapter() {
        Timber.d("검색 리사이클러뷰 초기화")
        adapter = SearchAdapter()
        binding.rvSearch.adapter = adapter.apply {
            submitList(viewModel.searchList)
        }
    }

    private fun initEditText() {
        Timber.d("검색 editText 설정")
        //아래는 엔터키 눌렀을 때 적용되는 코드.. 근데 차피 텍스트 바뀌면 자동으로 검색 돼서 굳이? 걍 뺄까 고민중임
//        binding.etSearch.setOnKeyListener { _, keyCode, event ->
//            var handled = false
//            if ((event.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                // 엔터가 눌리면
//                Timber.d("검색 editText 엔터 눌림")
//                onTextDebounced(binding.etSearch.text.toString())
//                handled = true
//            }
//            handled
//        }

        binding.etSearch.doAfterTextChanged { text ->
            Timber.d("검색 editText 텍스트 수정됨")
            searchDebouncer.setDelay(text.toString(), 500L) {
                onTextDebounced(text.toString())
            }
        }
    }

    /** 현재 -> 뷰모델의 list에서 키워드를 포함한 데이터만 var resultList에 추가
     * 바꿀 것-> 뷰모델 검색 api에 keyword 전달, 결과 list 받아오기 */
    private fun onTextDebounced(keyword: String) {
        Timber.d("검색 ${keyword}로 onTextDebouncer 실행")
        val resultList = mutableListOf<SearchDetailData>()
        for (data in viewModel.searchList) {
            if (data.address.contains(keyword)) {
                resultList.add(data)
                Timber.d("검색 ${data} 추가")
            }
        }
        renewAdapter(resultList)
    }

    /**이렇게 갱신하는 거 맞나?*/
    private fun renewAdapter(searchList: MutableList<SearchDetailData>) {
        Timber.d("검색 리스트 갱신 ${searchList}")
        adapter = SearchAdapter()
        binding.rvSearch.adapter = adapter.apply {
            updateSearchResults(searchList)
            submitList(searchList)
        }
    }
}