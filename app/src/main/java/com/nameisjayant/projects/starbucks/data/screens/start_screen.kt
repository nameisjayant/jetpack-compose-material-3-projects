package com.nameisjayant.projects.starbucks.data.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.navigation.NavHostController
import com.nameisjayant.projects.starbucks.data.components.LogoComponent
import com.nameisjayant.projects.starbucks.data.navigation.home
import com.nameisjayant.projects.ui.theme.Background
import kotlinx.coroutines.delay

@Composable
fun StartScreen(
    navHostController: NavHostController
) {

    LaunchedEffect(key1 = Unit) {
        delay(2000)
        navHostController.navigate(home)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background), contentAlignment = Alignment.Center
    ) {
        LogoComponent()
    }


}