package com.android.superheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.android.superheroes.model.Hero
import com.android.superheroes.model.HeroesRepository
import com.android.superheroes.ui.theme.Shapes
import com.android.superheroes.ui.theme.SuperheroesTheme

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.card_elevation)),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(all = dimensionResource(R.dimen.padding_medium))
        ) {
            Column(modifier = Modifier.weight(1f)) {
                HeroTitle(heroTitleRes = hero.nameRes)
                HeroDescription(heroDescriptionRes = hero.descriptionRes)
            }
            Box(modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_medium))) {
                HeroAvatar(imageRes = hero.imageRes)
            }
        }
    }
}

@Composable
fun HeroTitle(@StringRes heroTitleRes: Int, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Text(
            text = stringResource(heroTitleRes),
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
fun HeroDescription(@StringRes heroDescriptionRes: Int, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Text(
            text = stringResource(heroDescriptionRes),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun HeroAvatar(@DrawableRes imageRes: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(imageRes),
        contentDescription = null,
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .clip(Shapes.small),
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
fun HeroItemPreview() {
    SuperheroesTheme {
        HeroItem(hero = HeroesRepository.heroes.first())
    }
}
