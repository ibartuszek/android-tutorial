package com.android.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.artspace.model.ArtworkData
import com.android.artspace.model.ArtworkDataFactory
import com.android.artspace.ui.theme.ArtSpaceTheme
import com.android.artspace.ui.theme.ButtonColor
import com.android.artspace.ui.theme.TitleBackGroundColor
import kotlin.math.max
import kotlin.math.min

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ArtSpace(ArtworkDataFactory.create())
                }
            }
        }
    }
}

@Composable
fun ArtSpace(artworkDataList: List<ArtworkData>, modifier: Modifier = Modifier) {
    var index: Int by remember { mutableStateOf(0) }
    val indexCopy = index
    println(indexCopy)
    val currentData = artworkDataList[index]
    Column(
        modifier = modifier.fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_small))
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Bottom
    ) {
        ArtSpaceCard(
            artworkData = currentData,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_small))
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_large)))
        ArtSpaceTitle(
            artworkData = currentData,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_medium)))
        ArtSpaceButtons(
            previousPicture = { index = previousPictureIndex(index) },
            nextPicture = { index = nextPictureIndex(index, artworkDataList.size) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

private fun previousPictureIndex(index: Int): Int = max(0, index - 1)

private fun nextPictureIndex(index: Int, size: Int) = min(size - 1, index + 1)

@Composable
fun ArtSpaceCard(artworkData: ArtworkData, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.card_elevation)),
        modifier = modifier
    ) {
        Image(
            painter = painterResource(artworkData.drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.card_picture_padding))
                .fillMaxWidth()
                .height(dimensionResource(R.dimen.card_picture_height))
        )
    }
}

@Composable
fun ArtSpaceTitle(artworkData: ArtworkData, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Spacer(modifier = Modifier.weight(0.1f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.background(TitleBackGroundColor)
                .weight(0.8f)
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Text(
                text = stringResource(artworkData.title),
                fontSize = dimensionResource(R.dimen.card_title_size).value.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(artworkData.author),
                    fontWeight = FontWeight.Bold,
                    fontSize = dimensionResource(R.dimen.card_sub_title_size).value.sp,
                    modifier = Modifier
                )
                Text(
                    text = "(${stringResource(artworkData.year)})",
                    fontSize = dimensionResource(R.dimen.card_sub_title_size).value.sp,
                    modifier = Modifier
                )
            }
        }
        Spacer(modifier = Modifier.weight(0.1f))
    }
}

@Composable
fun ArtSpaceButtons(
    previousPicture: () -> Unit,
    nextPicture: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Spacer(modifier = Modifier.weight(0.05f))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.weight(0.9f)
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            ArtSpaceButton(
                label = R.string.previous_button_text,
                onClick = previousPicture
            )
            ArtSpaceButton(
                label = R.string.next_button_text,
                onClick = nextPicture
            )
        }
        Spacer(modifier = Modifier.weight(0.05f))
    }
}

@Composable
fun ArtSpaceButton(
    @StringRes label: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.width(dimensionResource(R.dimen.button_width)),
        colors = ButtonDefaults.buttonColors(containerColor = ButtonColor),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = dimensionResource(R.dimen.button_elevation)),
        border = ButtonDefaults.outlinedButtonBorder,
        content = {
            Text(text = stringResource(label))
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpace(ArtworkDataFactory.create())
    }
}
