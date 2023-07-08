package com.nameisjayant.projects.furniture.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nameisjayant.projects.furniture.screens.CheckOutScreen
import com.nameisjayant.projects.furniture.screens.HomeScreen
import com.nameisjayant.projects.furniture.screens.ProductDetailScreen


@Composable
fun FurnitureNavigation() {

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = Home){
        composable(Home){
            HomeScreen(navHostController)
        }

        composable(ProductDetail){
            ProductDetailScreen(navHostController)
        }

        composable(Checkout){
            CheckOutScreen(navHostController)
        }

    }

}

const val Home = "home_screen"
const val ProductDetail = "product_detail_screen"
const val Checkout = "check_out_screen"