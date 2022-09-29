package com.example.hiltnavigationinjection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hiltnavigationinjection.common.NavigationParameter.AGE_PARAMETER
import com.example.hiltnavigationinjection.common.NavigationParameter.NAME_PARAMETER
import com.example.hiltnavigationinjection.common.NavigationParameter.VEGETABLE_PARAMETER
import com.example.hiltnavigationinjection.common.NavigationRoute.AGE_DESTINATION
import com.example.hiltnavigationinjection.common.NavigationRoute.HOME_DESTINATION
import com.example.hiltnavigationinjection.common.NavigationRoute.NAME_DESTINATION
import com.example.hiltnavigationinjection.common.NavigationRoute.VEGETABLE_DESTINATION
import com.example.hiltnavigationinjection.screen.AgeScreen
import com.example.hiltnavigationinjection.screen.HomeScreen
import com.example.hiltnavigationinjection.screen.NameScreen
import com.example.hiltnavigationinjection.screen.VegetableScreen
import com.example.hiltnavigationinjection.ui.theme.HiltNavigationInjectionTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HiltNavigationInjectionTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavigationHost(navController)
                }
            }
        }
    }
}

@Composable
private fun NavigationHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HOME_DESTINATION
    ) {
        // The first screen shown upon startup
        composable(route = HOME_DESTINATION) {
            HomeScreen(
                onAgeSelected = { age ->
                    navController.navigate("${AGE_DESTINATION}/$age")
                },
                onPersonSelected = { name ->
                    navController.navigate("${NAME_DESTINATION}/$name")
                },
                onVegetableSelected = { veggie ->
                    navController.navigate("${VEGETABLE_DESTINATION}/$veggie")
                }
            )
        }
        // The screen that uses the age
        composable(
            route = "${AGE_DESTINATION}/{${AGE_PARAMETER}}",
            arguments = listOf(
                // We take the name from the route parameter
                navArgument(AGE_PARAMETER) {
                    type = NavType.IntType
                }
            )
        ) {
            // Note that the person screen does NOT have any parameters passed in
            AgeScreen()
        }
        // The screen that uses the name
        composable(
            route = "${NAME_DESTINATION}/{${NAME_PARAMETER}}",
            arguments = listOf(
                // We take the name from the route parameter
                navArgument(NAME_PARAMETER) {
                    type = NavType.StringType
                }
            )
        ) {
            // Same deal here, nothing passed through to the screen
            NameScreen()
        }
        // The screen that uses the name
        composable(
            route = "${VEGETABLE_DESTINATION}/{${VEGETABLE_PARAMETER}}",
            arguments = listOf(
                // We take the name from the route parameter
                navArgument(VEGETABLE_PARAMETER) {
                    type = NavType.StringType
                }
            )
        ) {
            // And again nothing passed in, notice that we have a second parameter of 'String' type.
            VegetableScreen()
        }
    }
}
