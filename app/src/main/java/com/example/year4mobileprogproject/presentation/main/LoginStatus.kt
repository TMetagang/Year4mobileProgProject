package com.example.year4mobileprogproject.presentation.main

sealed class LoginStatus

data class loginSuccess(val email: String) : LoginStatus()
object loginError : LoginStatus()


