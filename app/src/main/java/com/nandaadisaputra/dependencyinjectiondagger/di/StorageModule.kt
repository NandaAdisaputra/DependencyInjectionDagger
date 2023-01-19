package com.nandaadisaputra.dependencyinjectiondagger.di

import android.content.Context
import com.nandaadisaputra.dependencyinjectiondagger.SessionManager
import dagger.Module
import dagger.Provides

@Module
class StorageModule {
    @Provides
    //Jika Anda membutuhkan Context, Anda cukup menambahkan @BindsInstance
    // pada Component nantinya.
    fun provideSessionManager(context: Context): SessionManager = SessionManager(context)
}