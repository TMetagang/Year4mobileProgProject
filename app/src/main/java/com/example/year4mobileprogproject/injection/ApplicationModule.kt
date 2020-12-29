package com.example.year4mobileprogproject.injection

import com.example.year4mobileprogproject.data.repository.UserRepository
import com.example.year4mobileprogproject.domain.usecase.CreateUserUseCase
import com.example.year4mobileprogproject.presentation.main.MainViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val presentationModule = module {
    factory{

        MainViewModel(get())

    }
}

val domainModule : Module = module {
    factory { CreateUserUseCase(get()) }
}

val dataModule : Module = module { single { UserRepository() } }