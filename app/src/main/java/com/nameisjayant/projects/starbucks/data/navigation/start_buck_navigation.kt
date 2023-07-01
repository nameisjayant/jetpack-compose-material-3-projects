package com.nameisjayant.projects.starbucks.data.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nameisjayant.projects.starbucks.data.screens.HomeScreen
import com.nameisjayant.projects.starbucks.data.screens.ProductDetailScreen
import com.nameisjayant.projects.starbucks.data.screens.StartScreen

@Composable
fun StarBucksNavigation() {

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = start){
        composable(start){
            StartScreen(navHostController = navHostController)
        }
        composable(home){
            HomeScreen(navHostController = navHostController)
        }
        composable(product_detail){
            ProductDetailScreen(navHostController = navHostController)
        }
    }

}

const val start = "start_screen"
const val home = "home_screen"
const val product_detail ="product_detail_screen"