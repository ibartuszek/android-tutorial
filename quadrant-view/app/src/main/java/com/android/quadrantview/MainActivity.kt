package com.android.quadrantview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.android.quadrantview.model.QuadrantData
import com.android.quadrantview.model.QuadrantItem
import com.android.quadrantview.model.QuadrantItemFactory.createQuadrantData
import com.android.quadrantview.ui.theme.QuadrantViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    QuadrantDataView(createQuadrantData())
                }
            }
        }
    }
}

@Composable
fun QuadrantDataView(data: QuadrantData, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(Modifier.weight(1f)) {
            QuadrantItemView(
                item = data.item1,
                modifier = Modifier.weight(1f)
            )
            QuadrantItemView(
                item = data.item2,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            QuadrantItemView(
                item = data.item3,
                modifier = Modifier.weight(1f)
            )
            QuadrantItemView(
                item = data.item4,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun QuadrantItemView(item: QuadrantItem, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
            .background(color = item.backgroundColor)
            .padding(dimensionResource(R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(item.title),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
        )
        Text(
            text = stringResource(item.content),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantDataViewPreview() {
    QuadrantViewTheme {
        QuadrantDataView(createQuadrantData())
    }
}
