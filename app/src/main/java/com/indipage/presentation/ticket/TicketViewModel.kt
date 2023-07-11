package com.indipage.presentation.ticket

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.indipage.data.dto.request.RequestSignInDto
import com.indipage.data.dto.response.TestRecyclerviewImage
import com.indipage.domain.repository.TestApiRepository
import com.indipage.util.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class TicketViewModel @Inject constructor(
) : ViewModel() {

    private val _openProductEvent = MutableLiveData<Event<String>>()
    val openProductEvent: LiveData<Event<String>> = _openProductEvent

    fun openQR() {
        _openProductEvent.value = Event("test")
    }

}