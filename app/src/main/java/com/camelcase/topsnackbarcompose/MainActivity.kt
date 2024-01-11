package com.camelcase.topsnackbarcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.camelcase.topsnackbarcompose.ui.theme.TopSnackBarComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopSnackBarComposeTheme {
                SnackBarScreen()
            }
        }
    }
}

