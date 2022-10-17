package com.example.passhash

import android.app.Application
import com.example.passhash.di.repositoryModule
import com.example.passhash.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @author : Mingaleev D
 * @data : 17/10/2022
 */

class AppApplication:Application() {

  override fun onCreate() {
    super.onCreate()
    startKoin {
      androidContext(this@AppApplication)
      modules(viewModelModule)
      modules(repositoryModule)
    }
  }
}