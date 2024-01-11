package com.camelcase.topsnackbarcompose

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarData
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SnackBarScreen() {
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(backgroundColor = Color.Gray) {
        Column(modifier = Modifier.padding(it)) {
            SnackbarHost(
                modifier = Modifier.
                animateContentSize(animationSpec = tween(300, easing = FastOutSlowInEasing)),
                hostState = snackBarHostState
            ) { snackBarData: SnackbarData ->
                CustomSnackBar(snackBarHostState, snackBarData.message) }
            ScreenContent(modifier = Modifier.fillMaxWidth().weight(1f))
            Button(onClick = {
                snackBarHostState.showSnackBarWithDismiss(scope, "Error Message")
            }) {
                Text(text = "Click Me", modifier = Modifier.fillMaxWidth().padding(8.dp),
                    textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun ScreenContent(modifier: Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.then(Modifier.background(Color.Magenta))) {
        Text(text = "Screen Content", color = Color.White)
    }
}