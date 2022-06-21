package com.ilhamhadisyah.suitmediatest.utils

import com.ilhamhadisyah.suitmediatest.data.model.GuestModel

interface RecyclerViewItemSelected {
    fun onItemSelected(model : GuestModel)
}