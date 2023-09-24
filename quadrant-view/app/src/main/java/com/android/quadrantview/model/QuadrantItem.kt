package com.android.quadrantview.model

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.android.quadrantview.R

data class QuadrantData(
    val item1: QuadrantItem,
    val item2: QuadrantItem,
    val item3: QuadrantItem,
    val item4: QuadrantItem,
)

data class QuadrantItem(
    val backgroundColor: Color,
    @StringRes val title: Int,
    @StringRes val content: Int
)

object QuadrantItemFactory {

    fun createQuadrantData() = QuadrantData(
        item1 = QuadrantItem(
            backgroundColor = Color(0xFFEADDFF),
            title = R.string.item1_title,
            content = R.string.item1_content
        ),
        item2 = QuadrantItem(
            backgroundColor = Color(0xFFD0BCFF),
            title = R.string.item2_title,
            content = R.string.item2_content
        ),
        item3 = QuadrantItem(
            backgroundColor = Color(0xFFB69DF8),
            title = R.string.item3_title,
            content = R.string.item3_content
        ),
        item4 = QuadrantItem(
            backgroundColor = Color(0xFFF6EDFF),
            title = R.string.item4_title,
            content = R.string.item4_content
        )
    )
}
