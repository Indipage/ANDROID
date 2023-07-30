package com.indipage.util

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

fun <T : Any> pagingSubmitData(
    lifecycleOwner: LifecycleOwner,
    getData: Flow<PagingData<T>>,
    pagingAdapter: PagingDataAdapter<T, *>
) {
    lifecycleOwner.lifecycleScope.launch {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            launch {
                getData.collectLatest { pagingData ->
                    pagingAdapter.submitData(pagingData)
                }
            }
        }
    }
}