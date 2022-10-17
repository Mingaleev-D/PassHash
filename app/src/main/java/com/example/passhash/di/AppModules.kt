package com.example.passhash.di

import com.example.passhash.repository.PasswordRepository
import com.example.passhash.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
  viewModel { MainViewModel(get()) }
}

val repositoryModule = module {
  single { PasswordRepository() }
}