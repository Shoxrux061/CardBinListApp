package com.cardbin.shared_core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cardbin.shared_core.R

@Composable
fun SmallAppButton(onClick: () -> Unit, text: String, modifier: Modifier = Modifier) {

    val colors = MaterialTheme.colorScheme
    val typography = MaterialTheme.typography

    Button(
        modifier = modifier
            .height(40.dp),
        onClick = {
            onClick.invoke()
        },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(colors.primary),
        content = {
            Text(
                text = text,
                style = typography.titleSmall
            )
        }
    )

}

@Composable
fun ErrorScreen(errorText: String, onRetryClick: () -> Unit) {

    val colors = MaterialTheme.colorScheme
    val typography = MaterialTheme.typography

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
    ) {

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(R.drawable.ic_error),
                contentDescription = null
            )

            Text(
                modifier = Modifier.padding(vertical = 20.dp),
                text = errorText,
                style = typography.titleMedium,
                color = colors.outline
            )

            SmallAppButton(
                onClick = onRetryClick,
                text = "Retry"
            )

        }

    }

}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary
        )
    }
}