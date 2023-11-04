package com.android.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.android.courses.data.DataSource
import com.android.courses.model.Topic
import com.android.courses.ui.theme.TopicCardBackgroundColor
import com.android.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    CoursesApp(topics = DataSource.topics)
                }
            }
        }
    }
}

@Composable
fun CoursesApp(topics: List<Topic>, modifier: Modifier = Modifier) {
    val smallPadding = dimensionResource(R.dimen.padding_small)
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(smallPadding),
        horizontalArrangement = Arrangement.spacedBy(smallPadding),
        modifier = modifier.padding(smallPadding),
    ) {
        items(topics) { topic ->
            TopicCard(topic = topic)
        }
    }
}

@Composable
fun TopicCard(
    topic: Topic,
    modifier: Modifier = Modifier,
    cardPictureSize: Dp = dimensionResource(R.dimen.card_picture_size)
) {
    val smallPadding = dimensionResource(R.dimen.padding_small)
    val mediumPadding = dimensionResource(R.dimen.padding_medium)
    Card(
        colors = CardDefaults.cardColors(containerColor = TopicCardBackgroundColor),
        modifier = modifier.padding(smallPadding)
            .height(cardPictureSize)
    ) {
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                painter = painterResource(topic.drawableResource),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.width(cardPictureSize)
            )
            Column(
                modifier = Modifier.padding(
                    start = smallPadding,
                    end = mediumPadding
                ),
            ) {
                Text(
                    text = stringResource(topic.topicName),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = smallPadding)
                )
                Row {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                    )
                    Text(
                        text = topic.comments.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = smallPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoursesAppPreview() {
    CoursesTheme {
        CoursesApp(topics = DataSource.topics)
    }
}