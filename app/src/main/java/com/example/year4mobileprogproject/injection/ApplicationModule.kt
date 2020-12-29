package com.example.year4mobileprogproject.injection

import com.example.year4mobileprogproject.presentation.main.MainViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory{MainViewModel()}
}