package com.example.tiptime

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun `test calculateTip should calculate properly without rounding`() {
        // given
        val expected = NumberFormat.getCurrencyInstance().format(1.22)

        // when
        val actual = calculateTip(amount = 11.1, tipPercent = 11.0, roundUp = false)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `test calculateTip should calculate properly with rounding`() {
        // given
        val expected = NumberFormat.getCurrencyInstance().format(2)


        // when
        val actual = calculateTip(amount = 11.1, tipPercent = 11.0, roundUp = true)

        // then
        assertEquals(expected, actual)
    }
}
