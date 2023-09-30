package com.example.tiptime

import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testCalculateShouldShowProperValueWithoutRounding() {
        // given
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeLayout()
            }
        }
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        // when
        composeTestRule.onNodeWithText("Bill Amount")
            .assertExists("No bill amount node was found")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage")
            .assertExists("No tip node was found")
            .performTextInput("20")
        composeTestRule.onNodeWithTag("TipSwitch")
            .assertExists("No round up node was found")
            .assertIsOff()

        // then
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip")
            .assertExists("No node with this text was found")
    }

    @Test
    fun testCalculateShouldShowProperValueWithRounding() {
        // given
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeLayout()
            }
        }
        val expectedTip = NumberFormat.getCurrencyInstance().format(3.0)

        // when
        composeTestRule.onNodeWithText("Bill Amount")
            .assertExists("No bill amount node was found")
            .performTextInput("11")
        composeTestRule.onNodeWithText("Tip Percentage")
            .assertExists("No tip node was found")
            .performTextInput("20")
        composeTestRule.onNodeWithTag("TipSwitch")
            .assertExists("No round up node was found")
            .performClick()
            .assertIsOn()

        // then
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip")
            .assertExists("No node with this text was found")
    }
}
