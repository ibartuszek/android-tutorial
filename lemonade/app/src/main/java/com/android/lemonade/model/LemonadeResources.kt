package com.android.lemonade.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.android.lemonade.R

data class LemonadeState(
    private val remainingClicks: Int = DEFAULT_SQUEEZE,
    val resource: LemonadeResources = LemonadeResources.LEMON_TREE
) {

    fun click(): LemonadeState {
        var remainingClicks = this.remainingClicks - 1
        var resource = this.resource
        if (remainingClicks <= 0) {
            resource = resource.next()
            remainingClicks = if (resource == LemonadeResources.LEMON_SQUEEZE) {
                (MINIMUM_LEMON_SQUEEZE..MAXIMUM_LEMON_SQUEEZE).random()
            } else { DEFAULT_SQUEEZE }
        }
        return LemonadeState(resource = resource, remainingClicks = remainingClicks)
    }

    companion object {
        private const val DEFAULT_SQUEEZE = 1
        private const val MINIMUM_LEMON_SQUEEZE = 2
        private const val MAXIMUM_LEMON_SQUEEZE = 4
    }
}

enum class LemonadeResources(
    @StringRes val description: Int,
    @DrawableRes val painter: Int,
) {
    LEMON_TREE(description = R.string.lemon_tree, painter = R.drawable.lemon_tree),
    LEMON_SQUEEZE(description = R.string.lemon_squeeze, painter = R.drawable.lemon_squeeze),
    LEMON_DRINK(description = R.string.lemon_drink, painter = R.drawable.lemon_drink),
    LEMON_RESTART(description = R.string.lemon_restart, painter = R.drawable.lemon_restart);

    fun next(): LemonadeResources =
        when (this) {
            LEMON_TREE -> LEMON_SQUEEZE
            LEMON_SQUEEZE -> LEMON_DRINK
            LEMON_DRINK -> LEMON_RESTART
            LEMON_RESTART -> LEMON_TREE
        }
}