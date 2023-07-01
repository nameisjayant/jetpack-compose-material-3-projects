package com.nameisjayant.projects

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nameisjayant.projects.chat.components.navigation.MainNavigation
import com.nameisjayant.projects.starbucks.data.navigation.StarBucksNavigation
import com.nameisjayant.projects.ui.theme.ChatAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAppTheme {
                StarBucksNavigation()
            }
        }
    }
}