package com.android.composearticle.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.android.composearticle.R

data class ArticleData(
    @DrawableRes val headerImageResource: Int,
    @StringRes val tile: Int,
    @StringRes val summary: Int,
    @StringRes val content: Int
)

object ArticleDataFactory {

    fun create() = ArticleData(
        headerImageResource = R.drawable.bg_compose_background,
        tile = R.string.article_title,
        summary = R.string.article_summary,
        content = R.string.article_content
    )
}
