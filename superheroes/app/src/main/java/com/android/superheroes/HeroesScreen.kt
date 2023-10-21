package com.android.superheroes

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.android.superheroes.model.Hero
import com.android.superheroes.model.HeroesRepository
import com.android.superheroes.ui.theme.SuperheroesTheme

@Composable
fun HeroesScreen(heroes: List<Hero>, modifier: Modifier = Modifier, contentPadding: PaddingValues) {
    LazyColumn(
        contentPadding = contentPadding,
        modifier = modifier.padding(
            start = dimensionResource(R.dimen.padding_medium),
            end = dimensionResource(R.dimen.padding_medium),
            top = dimensionResource(R.dimen.padding_small),
            bottom = dimensionResource(R.dimen.padding_small),
        )
    ) {
        items(heroes) {
            HeroItem(
                hero = it,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroesScreenPreview() {
    SuperheroesTheme {
        HeroesScreen(heroes = HeroesRepository.heroes, contentPadding = PaddingValues())
    }
}
