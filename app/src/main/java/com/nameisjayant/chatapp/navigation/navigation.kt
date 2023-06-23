package com.nameisjayant.chatapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nameisjayant.chatapp.screens.ChatScreen
import com.nameisjayant.chatapp.screens.HomeScreen
import com.nameisjayant.chatapp.screens.StartScreen

@Composable
fun MainNavigation() {

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = START_SCREEN) {
        composable(START_SCREEN) {
            StartScreen(navHostController)
        }
        composable(HOME_SCREEN) {
            HomeScreen(navHostController)
        }
        composable(CHAT_SCREEN) {
            ChatScreen(navHostController)
        }
    }

}

const val START_SCREEN = "Start screen"
const val HOME_SCREEN = "Home screen"
const val CHAT_SCREEN = "Char screen"