package com.ilhamhadisyah.suitmediatest.utils

import com.ilhamhadisyah.suitmediatest.data.model.EventModel

interface EventCardListener {
    fun onCardSelected(model: EventModel)
}