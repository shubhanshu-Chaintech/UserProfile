package org.example.project

import App
import Presentation.ProfileScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.app.userprofile.Res
import org.jetbrains.compose.resources.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}