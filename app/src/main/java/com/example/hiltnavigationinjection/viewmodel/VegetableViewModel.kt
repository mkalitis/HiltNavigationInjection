package com.example.hiltnavigationinjection.viewmodel

import androidx.lifecycle.ViewModel
import com.example.hiltnavigationinjection.di.VegetableParameter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class VegetableViewModel @Inject constructor(
    @VegetableParameter private val favouriteVegetable: String
) : ViewModel() {
    val state: Flow<String> = flow {
        emit("The best vegetable in the world is $favouriteVegetable")
    }
}