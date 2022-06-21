package com.ilhamhadisyah.suitmediatest.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class EventModel(
    var id: Int? = 0,
    var title: String? = "",
    var imageUrl: String? = "",
    var description: String? = "",
    var lat: Double? = 0.0,
    var lng: Double? = 0.0,
    var date: String? = "",
    var time: String? = ""
) : Parcelable