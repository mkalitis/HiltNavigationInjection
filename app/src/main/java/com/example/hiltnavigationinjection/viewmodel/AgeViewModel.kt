package com.example.hiltnavigationinjection.viewmodel

import androidx.lifecycle.ViewModel
import com.example.hiltnavigationinjection.di.AgeParameter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class AgeViewModel @Inject constructor(
    @AgeParameter private val ourAge: Int
) : ViewModel() {
    val state: Flow<String> = flow {
        emit("Our age is $ourAge")
    }
}