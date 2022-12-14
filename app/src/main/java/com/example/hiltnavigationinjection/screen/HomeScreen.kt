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
package com.example.hiltnavigationinjection.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.hiltnavigationinjection.viewmodel.HomeViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeScreen(
    onAgeSelected: (age: Int) -> Unit,
    onPersonSelected: (name: String) -> Unit,
    onVegetableSelected: (Vegetable: String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle(
        HomeViewModel.HomeState(
            age = 0,
            name = "",
            vegetable = ""
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                onAgeSelected(state.value.age)
            }
        ) {
            Text(text = "Send ${state.value.age} to the AGE screen")
        }
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                onPersonSelected(state.value.name)
            }
        ) {
            Text(text = "Send ${state.value.name} to the NAME screen")
        }
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                onVegetableSelected(state.value.vegetable)
            }
        ) {
            Text(text = "Send ${state.value.vegetable} to the VEGGIE screen")
        }
    }
}