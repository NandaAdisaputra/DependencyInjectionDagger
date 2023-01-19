package com.nandaadisaputra.dependencyinjectiondagger

import android.app.Application
import com.nandaadisaputra.dependencyinjectiondagger.di.AppComponent
import com.nandaadisaputra.dependencyinjectiondagger.di.DaggerAppComponent

open class MyApplication : Application(){
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(
            applicationContext
        )
    }
}