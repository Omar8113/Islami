package com.route.islami.tabs.Quran

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Chapter(
    val ar_title: String,
    val en_title: String,
    val versesNumber: String,
    val index: Int
) : Parcelable