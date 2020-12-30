package com.example.year4mobileprogproject.injection

import android.content.Context
import androidx.room.Room
import com.example.year4mobileprogproject.data.local.AppDatabase
import com.example.year4mobileprogproject.data.local.DatabaseDao
import com.example.year4mobileprogproject.data.repository.UserRepository
import com.example.year4mobileprogproject.domain.usecase.CreateUserUseCase
import com.example.year4mobileprogproject.domain.usecase.GetUserUseCase
import com.example.year4mobileprogproject.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val presentationModule = module {
    factory{MainViewModel(get(), get())}
}

val domainModule = module{
    factory { CreateUserUseCase(get())
    }
    factory { GetUserUseCase(get())
    }
}

val dataModule = module{
    single { UserRepository(get()) }
    single { createDataBase(androidContext())}
}

fun createDataBase(context: Context): DatabaseDao {
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}