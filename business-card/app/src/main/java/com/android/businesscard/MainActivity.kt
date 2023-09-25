package com.android.businesscard

import android.graphics.Color.parseColor
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.android.businesscard.model.BusinessCardData
import com.android.businesscard.model.BusinessCardDataFactory
import com.android.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    BusinessCard(data = BusinessCardDataFactory.create())
                }
            }
        }
    }
}

@Composable
fun BusinessCard(data: BusinessCardData, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
            .background(color = Color(parseColor("#d2e8d4"))),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        BusinessCardHeading(data = data)
        Spacer(
            modifier = Modifier.height(dimensionResource(R.dimen.spacer_height))
        )
        BusinessCardContactDetails(
            data = data,
            modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
        )
    }
}

@Composable
fun BusinessCardHeading(data: BusinessCardData, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val titleTextSize = dimensionResource(R.dimen.title_text_size)
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier.width(dimensionResource(R.dimen.logo_size))
                .height(dimensionResource(R.dimen.logo_size))
                .background(stringResource(R.string.logo_background_color).parseHexColor()),
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(data.fullName),
            fontSize = titleTextSize.value.sp,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(data.title),
            fontWeight = FontWeight.Bold,
            color = stringResource(R.string.text_color).parseHexColor(),
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
    }
}

@Composable
fun BusinessCardContactDetails(data: BusinessCardData, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        BusinessCardContactDetailsItem(
            text = data.phoneNumber,
            icon = Icons.Rounded.Phone
        )
        BusinessCardContactDetailsItem(
            text = data.socialMedia,
            icon = Icons.Rounded.Share
        )
        BusinessCardContactDetailsItem(
            text = data.email,
            icon = Icons.Rounded.Email
        )
    }
}

@Composable
fun BusinessCardContactDetailsItem(@StringRes text: Int, icon: ImageVector, modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(bottom = dimensionResource(R.dimen.padding_small))) {
        Icon(
            imageVector = icon,
            contentDescription = icon.name,
            tint = stringResource(R.string.text_color).parseHexColor(),
            modifier = Modifier.padding(end = dimensionResource(R.dimen.padding_medium))
        )
        Text(
            text = stringResource(text)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(data = BusinessCardDataFactory.create())
    }
}

private fun String.parseHexColor(): Color = Color(parseColor(this))
