package com.android.superheroes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.android.superheroes.model.Hero
import com.android.superheroes.model.HeroesRepository
import com.android.superheroes.ui.theme.SuperheroesTheme

@Composable
fun HeroesScreen(heroes: List<Hero>, modifier: Modifier = Modifier, contentPadding: PaddingValues) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately
            targetState = true
        }
    }

    // Fade in entry animation for the entire list
    AnimatedVisibility(
        visibleState = visibleState,
        enter = fadeIn(
            animationSpec = spring(dampingRatio = DampingRatioLowBouncy)
        ),
        exit = fadeOut(),
        modifier = modifier
    ) {
        LazyColumn(contentPadding = contentPadding) {
            items(heroes) {
                HeroItem(
                    hero = it,
                    modifier = Modifier.padding(
                        horizontal = dimensionResource(id = R.dimen.padding_medium),
                        vertical = dimensionResource(id = R.dimen.padding_small)
                    )
                )
            }
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
