package com.android.businesscard.model

import androidx.annotation.StringRes
import com.android.businesscard.R

data class BusinessCardData(
    @StringRes val fullName: Int,
    @StringRes val title: Int,
    @StringRes val phoneNumber: Int,
    @StringRes val socialMedia: Int,
    @StringRes val email: Int,
)

object BusinessCardDataFactory {

    fun create() = BusinessCardData(
        fullName = R.string.full_name, 
        title = R.string.title,
        phoneNumber = R.string.phone_number, 
        socialMedia = R.string.social_media, 
        email = R.string.email
    )
}
