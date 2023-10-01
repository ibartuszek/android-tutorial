package com.android.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @DrawableRes val drawableResource: Int,
    @StringRes val topicName: Int,
    val comments: Int
)
