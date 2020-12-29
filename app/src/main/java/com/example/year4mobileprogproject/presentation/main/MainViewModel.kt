package com.example.year4mobileprogproject.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.year4mobileprogproject.injection.DataSource
import com.example.year4mobileprogproject.injection.moviePost

class MainViewModel : ViewModel(){

    var list: MutableLiveData<ArrayList<moviePost>> = MutableLiveData()

    fun onStart(){
        list.value = DataSource.createDataSet() //When you will add element in listData, the MainViewModel will tell the activity that something changed
    }
}