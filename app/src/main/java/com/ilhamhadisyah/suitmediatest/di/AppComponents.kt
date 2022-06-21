package com.ilhamhadisyah.suitmediatest.di

import android.app.Activity
import android.content.Context
import com.ilhamhadisyah.suitmediatest.ui.Screen4Activity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [VMModules::class, AppModule::class])
interface AppComponents {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponents
    }

    fun inject(activity: Screen4Activity)
}