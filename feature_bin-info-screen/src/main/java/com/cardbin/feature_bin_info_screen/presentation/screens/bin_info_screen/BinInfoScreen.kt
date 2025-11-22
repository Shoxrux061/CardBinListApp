package com.cardbin.feature_bin_info_screen.presentation.screens.bin_info_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.cardbin.feature_bin_info_screen.R
import com.cardbin.feature_bin_info_screen.data.mapper.toMap
import com.cardbin.feature_bin_info_screen.domain.models.CardInfoUi
import com.cardbin.shared_core.ui.components.ErrorScreen
import com.cardbin.shared_core.ui.components.LoadingScreen
import com.cardbin.shared_core.ui.components.SmallAppButton

@Composable
fun BinInfoScreen(viewModel: BinInfoViewModel) {

    val uiState = viewModel.uiState.collectAsState()

    val cardInfo = uiState.value.cardInfo
    val isLoading = uiState.value.isLoading
    val error = uiState.value.error

    when {

        isLoading -> {
            LoadingScreen()
        }

        error != null -> {
            ErrorScreen(error) { }
        }

    }

    BinInfoContent(viewModel, cardInfo?.toMap().orEmpty())

}

@Composable
fun BinInfoContent(viewModel: BinInfoViewModel, cardInfo: Map<String, String>) {

    val uiState = viewModel.uiState.collectAsState().value

    val textValue = uiState.textValue
    val isLoading = uiState.isLoading

    val isValid =
        textValue.text.length > 3 && textValue.text.replace(" ", "").length % 2 == 0 && !isLoading

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Spacer(Modifier.height(40.dp))

        CardItem(
            textValue = textValue,
            onValueChanged = {
                viewModel.changeTextFieldValue(it)
            }
        )

        SmallAppButton(
            modifier = Modifier.alpha(if (isValid) 1f else 0.5f),
            text = "Search",
            onClick = {
                if (isValid) {
                    viewModel.getCardBinInfo(textValue.text.replace(" ", ""))
                }
            }
        )

        if (cardInfo.isNotEmpty()) {
            CardInfoContainer(cardInfo)
        }

    }
}

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
            modifier = Modifier.fillMaxWidth().padding(
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

@Composable
fun CardItem(
    textValue: TextFieldValue,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1.585f),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF262F5A),
                            Color(0xFF3F51B5),
                            Color(0xFF9EAEFC),
                        )
                    )
                ),
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(R.drawable.ic_chip),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .height(40.dp)
                    .aspectRatio(1.8f)
            )



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                TextField(
                    maxLines = 1,
                    modifier = Modifier.fillMaxWidth(0.5f),
                    value = textValue,
                    onValueChange = { newValue ->
                        onValueChanged(newValue.text)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    textStyle = TextStyle(
                        fontFamily = FontFamily(Font(R.font.noto_medium)),
                        letterSpacing = 1.sp,
                        fontWeight = FontWeight.Medium,
                        fontSize = 22.sp,
                        color = MaterialTheme.colorScheme.secondary
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        unfocusedIndicatorColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
                Text(
                    text = "**** ****",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.noto_medium)),
                        letterSpacing = 1.sp,
                        fontWeight = FontWeight.Medium,
                        fontSize = 22.sp,
                        color = MaterialTheme.colorScheme.secondary
                    )
                )
            }
        }
    }
}