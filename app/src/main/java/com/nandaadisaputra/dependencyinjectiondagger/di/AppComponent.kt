package com.nandaadisaputra.dependencyinjectiondagger.di

import android.content.Context
import com.nandaadisaputra.dependencyinjectiondagger.HomeActivity
import com.nandaadisaputra.dependencyinjectiondagger.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
    fun inject(activity: MainActivity)
    fun inject(activity: HomeActivity)
}