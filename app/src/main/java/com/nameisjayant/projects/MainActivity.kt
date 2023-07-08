package com.nameisjayant.projects

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.nameisjayant.projects.chat.components.navigation.MainNavigation
import com.nameisjayant.projects.furniture.navigation.FurnitureNavigation
import com.nameisjayant.projects.starbucks.data.navigation.StarBucksNavigation
import com.nameisjayant.projects.ui.theme.ChatAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAppTheme {
                FurnitureNavigation()
            }
        }
    }
}