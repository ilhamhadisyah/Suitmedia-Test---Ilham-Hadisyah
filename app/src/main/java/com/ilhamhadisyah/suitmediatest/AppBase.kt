package com.ilhamhadisyah.suitmediatest

import android.app.Application
import com.ilhamhadisyah.suitmediatest.di.AppComponents
import com.ilhamhadisyah.suitmediatest.di.DaggerAppComponents

class AppBase : Application() {
    val components: AppComponents by lazy {
        DaggerAppComponents.factory().create(applicationContext)
    }
}