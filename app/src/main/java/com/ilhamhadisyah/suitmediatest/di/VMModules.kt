package com.ilhamhadisyah.suitmediatest.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ilhamhadisyah.suitmediatest.viewmodel.EventViewModel
import com.ilhamhadisyah.suitmediatest.viewmodel.GuestViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Suppress("unused")
@Module
abstract class VMModules {

    @Binds
    @IntoMap
    @ViewModelKey(GuestViewModel::class)
    abstract fun bindGuestViewModel(viewModel: GuestViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EventViewModel::class)
    abstract fun bindEventViewModel(viewModel: EventViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}