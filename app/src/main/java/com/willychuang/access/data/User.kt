package com.willychuang.access.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @Json(name = "login") val login: String,
    @Json(name = "avatar_url") val avatarUrl: String? = "",
    @Json(name = "site_admin") val siteAdmin: Boolean,
    @Json(name = "name")val name: String? = "",
    @Json(name = "bio") var bio: String? = "",
    @Json(name = "location")val location: String? = "",
    @Json(name = "blog")val blog: String? = ""
) : Parcelable