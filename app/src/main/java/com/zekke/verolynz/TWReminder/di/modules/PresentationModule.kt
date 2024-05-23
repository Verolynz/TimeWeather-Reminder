package com.zekke.verolynz.TWReminder.di.modules

import androidx.lifecycle.ViewModelProvider
import com.google.android.ads.mediationtestsuite.viewmodels.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PresentationModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}