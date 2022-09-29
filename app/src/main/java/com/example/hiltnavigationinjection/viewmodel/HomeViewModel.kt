package com.example.hiltnavigationinjection.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    // We have nothing passed in here.
) : ViewModel() {

    val state: Flow<HomeState> = flow {
        emit(
            HomeState(
                age = 30,
                name = "Buzz",
                vegetable = "Potato"
            )
        )
    }

    data class HomeState(
        val age: Int,
        val name: String,
        val vegetable: String
    )
}