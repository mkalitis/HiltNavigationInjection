package com.example.hiltnavigationinjection.viewmodel

import androidx.lifecycle.ViewModel
import com.example.hiltnavigationinjection.di.NameParameter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class NameViewModel @Inject constructor(
    @NameParameter private val ourName: String
) : ViewModel() {
    val state: Flow<String> = flow {
        emit("Hello, my name is $ourName")
    }
}