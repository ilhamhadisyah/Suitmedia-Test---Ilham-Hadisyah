package com.ilhamhadisyah.suitmediatest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ilhamhadisyah.suitmediatest.data.model.EventModel
import com.ilhamhadisyah.suitmediatest.data.repositories.DataRepositories
import javax.inject.Inject

class EventViewModel @Inject constructor(private val dataRepositories: DataRepositories) :
    ViewModel() {

    fun getEventData(): LiveData<List<EventModel>> = dataRepositories.getEventsAsLiveData()
}