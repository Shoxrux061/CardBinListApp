package com.cardbin.feature_card_history.presentation.screens.card_history

import androidx.compose.material3.Card
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CardInfoItem(
    pref: String,
    info: String,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = pref,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Thin,
            textAlign = TextAlign.Start,
            color = MaterialTheme.colorScheme.secondary

        )

        Spacer(Modifier.weight(1f))

        Text(
            text = info,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
            color = MaterialTheme.colorScheme.secondary
        )

    }

}

@Composable
fun CardInfoContainer(
    map: Map<String, String>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.primary
        )
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    20.dp
                ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(map.entries.toList()) { entry ->
                CardInfoItem(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    pref = entry.key,
                    info = entry.value
                )
            }
        }
    }
}