package com.mohitmandalia.adunit

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 *   Created by Mohit Mandalia
 */
open class AdUnitViewModel: ViewModel() {


    open val adUnitContent = MutableStateFlow(
        listOf(
            "Customized quote in minutes",
            "Quality coverage at an affordable rate",
            "97% customer satisfaction"
        )
    )

    private val _userQualification = MutableStateFlow(false)
    val userQualification: StateFlow<Boolean> = _userQualification.asStateFlow()

    init {
        changeUserState()
    }

    private fun changeUserState() {
        viewModelScope.launch {
            delay(3000)
            _userQualification.value = true
        }
    }

}