/*
 * Copyright 2022 Martin Kalitis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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