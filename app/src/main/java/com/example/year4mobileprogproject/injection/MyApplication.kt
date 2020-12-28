package com.example.year4mobileprogproject.injection

import android.app.Application
import com.example.year4mobileprogproject.injection.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application(){

    override fun onCreate(){
        super.onCreate()
        // start Koin!
        startKoin {
            // Android context
            androidContext(this@MyApplication)
            // modules
            modules(presentationModule)
        }
    }

}