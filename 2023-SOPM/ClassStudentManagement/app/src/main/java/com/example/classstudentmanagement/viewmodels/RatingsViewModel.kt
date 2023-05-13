package com.example.classstudentmanagement.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RatingsViewModel : ViewModel() {
    private var _rating = MutableLiveData<Int>(0)
    var rating : LiveData<Int> = _rating

    fun setRating() {
        _rating.value = rating.value?.plus(1)
    }
}