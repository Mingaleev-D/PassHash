package com.example.passhash.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.passhash.data.Password
import com.example.passhash.repository.PasswordRepository

class MainViewModel(
  private val passwordRepository: PasswordRepository
) : ViewModel() {
  val _passwordList: LiveData<List<Password>> =
    passwordRepository.passwords
  val passwordList: LiveData<List<Password>>
    get() = _passwordList

  fun save(newPassword: String) {
    passwordRepository.save(newPassword)
  }


}

fun List<Password>.asString(): String {
  return StringBuilder().run {
    this@asString.forEach {
      this.append("id: ${it.id}, password: ${it.password}\n")
    }
    this.toString()
  }
}