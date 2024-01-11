package com.camelcase.topsnackbarcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CustomSnackBar(
    hostState: SnackbarHostState,
    message: String,
    isRtl: Boolean = false,
) {
    Snackbar { CompositionLocalProvider(
            LocalLayoutDirection provides if (isRtl) LayoutDirection.Rtl else LayoutDirection.Ltr
        ) { Row(
                modifier = Modifier.statusBarsPadding().fillMaxWidth().wrapContentHeight()
                    .background(Color.Red, shape = RoundedCornerShape(10.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(modifier = Modifier.weight(1f).padding(10.dp), text = message.trim(),
                    color = colorResource(R.color.white), fontSize = 16.sp,
                    fontStyle = FontStyle.Normal, lineHeight = 16.sp, textAlign = TextAlign.Center
                )
                Icon(imageVector = Icons.Default.Close, contentDescription = null,
                    modifier = Modifier.size(16.dp)
                        .clickable { hostState.currentSnackbarData?.dismiss() }
                )
            }
        }
    }
}