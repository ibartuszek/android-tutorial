package com.android.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.unit.sp
import com.android.lemonade.model.LemonadeResources
import com.android.lemonade.model.LemonadeState
import com.android.lemonade.ui.theme.LemonadeTheme
import com.android.lemonade.ui.theme.Teal
import com.android.lemonade.ui.theme.Yellow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var state: LemonadeState by remember { mutableStateOf(LemonadeState()) }
    Scaffold(
        topBar = { LemonadeAppTopBar() }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            LemonadeAppContent(
                resource = state.resource,
                onClick = { state = state.click()}
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeAppTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Yellow,
            titleContentColor = Color.Black,
        ),
        title = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    )
}

@Composable
fun LemonadeAppContent(
    resource: LemonadeResources,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            shape = RoundedCornerShape(dimensionResource(R.dimen.padding_large)),
            colors = ButtonDefaults.buttonColors(containerColor = Teal),
            modifier = Modifier.height(dimensionResource(R.dimen.picture_size))
                .width(dimensionResource(R.dimen.picture_size)),
            onClick = onClick
        ) {
            Image(
                painter = painterResource(resource.painter),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }
        Text(
            text = stringResource(resource.description),
            fontSize = dimensionResource(R.dimen.description_font_size).value.sp,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_medium))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}