package com.android.artspace.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.android.artspace.R

data class ArtworkData(
    @DrawableRes val drawable: Int,
    @StringRes val title: Int,
    @StringRes val author: Int,
    @StringRes val year: Int
)

object ArtworkDataFactory {

    fun create(): List<ArtworkData> =
        listOf(
            ArtworkData(
                drawable = R.drawable.pindur1,
                title = R.string.title_pindur1,
                author = R.string.author_pindur1,
                year = R.string.year_pindur1,
            ),
            ArtworkData(
                drawable = R.drawable.pindur2,
                title = R.string.title_pindur2,
                author = R.string.author_pindur2,
                year = R.string.year_pindur2,
            ),
            ArtworkData(
                drawable = R.drawable.pindur3,
                title = R.string.title_pindur3,
                author = R.string.author_pindur3,
                year = R.string.year_pindur3,
            )
        )
}
