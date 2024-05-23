package com.zekke.verolynz.TWReminder.di

import android.app.Application
import com.zekke.verolynz.TWReminder.di.modules.DataModule
import com.zekke.verolynz.TWReminder.di.modules.DomainModule
import com.zekke.verolynz.TWReminder.di.modules.PresentationModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataModule::class,
        DomainModule::class,
        PresentationModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}