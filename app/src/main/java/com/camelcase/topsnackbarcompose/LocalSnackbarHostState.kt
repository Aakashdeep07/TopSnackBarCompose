package com.camelcase.topsnackbarcompose


import androidx.compose.material.SnackbarHostState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


fun SnackbarHostState.showSnackBarWithDismiss(
    coroutineScope: CoroutineScope,
    message: String
) {
    coroutineScope.launch {
        currentSnackbarData?.dismiss()
        showSnackbar(message)
    }
}

