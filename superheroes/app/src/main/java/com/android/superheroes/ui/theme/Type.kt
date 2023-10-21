package com.android.superheroes.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.android.superheroes.R

val Cabin = FontFamily(
    Font(R.font.cabin_bold, FontWeight.Bold),
    Font(R.font.cabin_regular, FontWeight.Normal)
)

// Set of Material typography styles to start with
val Typography = Typography(
    // Display is not needed on phones
    // displayLarge = ...,
    // displayMedium = ...,
    // displaySmall = ...,
    headlineLarge = TextStyle(
        fontFamily = Cabin,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Cabin,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = Cabin,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    // titleLarge = ,
    // titleMedium = ,
    // titleSmall = ,
    bodyLarge = TextStyle(
        fontFamily = Cabin,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    // bodyMedium = ,
    // bodySmall = ,
    // labelLarge = ,
    // labelMedium = ,
    // labelSmall = ,
)