package com.android.courses.data

import com.android.courses.R
import com.android.courses.model.Topic

object DataSource {
    val topics = listOf(
        Topic(topicName = R.string.architecture, comments = 58, drawableResource = R.drawable.architecture),
        Topic(topicName = R.string.crafts, comments = 121, drawableResource = R.drawable.crafts),
        Topic(topicName = R.string.business, comments = 78, drawableResource = R.drawable.business),
        Topic(topicName = R.string.culinary, comments = 118, drawableResource = R.drawable.culinary),
        Topic(topicName = R.string.design, comments = 423, drawableResource = R.drawable.design),
        Topic(topicName = R.string.fashion, comments = 92, drawableResource = R.drawable.fashion),
        Topic(topicName = R.string.film, comments = 165, drawableResource = R.drawable.film),
        Topic(topicName = R.string.gaming, comments = 164, drawableResource = R.drawable.gaming),
        Topic(topicName = R.string.drawing, comments = 326, drawableResource = R.drawable.drawing),
        Topic(topicName = R.string.lifestyle, comments = 305, drawableResource = R.drawable.lifestyle),
        Topic(topicName = R.string.music, comments = 212, drawableResource = R.drawable.music),
        Topic(topicName = R.string.painting, comments = 172, drawableResource = R.drawable.painting),
        Topic(topicName = R.string.photography, comments = 321, drawableResource = R.drawable.photography),
        Topic(topicName = R.string.tech, comments = 118, drawableResource = R.drawable.tech)
    )
}
