package com.example.hiltnavigationinjection.di

import androidx.lifecycle.SavedStateHandle
import com.example.hiltnavigationinjection.common.NavigationParameter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * This hooks up the navigation parameters to the named types via annotations.
 * We then use these to supply values directly to the view models.
 */
@Module
@InstallIn(ViewModelComponent::class)
class NavigationParameterModule {

    @Provides
    @AgeParameter
    @ViewModelScoped
    fun provideAgeParameter(savedStateHandle: SavedStateHandle): Int =
        savedStateHandle.get<Int>(NavigationParameter.AGE_PARAMETER)
            ?: throw IllegalArgumentException("Could not get the 'age' parameter")

    @Provides
    @NameParameter
    @ViewModelScoped
    fun provideNameParameter(savedStateHandle: SavedStateHandle): String =
        savedStateHandle.get<String>(NavigationParameter.NAME_PARAMETER)
            ?: throw IllegalArgumentException("Could not get the 'name' parameter")

    @Provides
    @VegetableParameter
    @ViewModelScoped
    fun provideVegetableParameter(savedStateHandle: SavedStateHandle): String =
        savedStateHandle.get<String>(NavigationParameter.VEGETABLE_PARAMETER)
            ?: throw IllegalArgumentException("Could not get the 'vegetable' parameter")

}