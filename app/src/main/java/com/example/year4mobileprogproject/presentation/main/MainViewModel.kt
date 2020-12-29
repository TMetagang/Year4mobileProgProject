package com.example.year4mobileprogproject.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.year4mobileprogproject.MovieRecyclerAdapter
import com.example.year4mobileprogproject.TopSpacingItemDecoration
import com.example.year4mobileprogproject.domain.entity.User
import com.example.year4mobileprogproject.domain.usecase.CreateUserUseCase
import com.example.year4mobileprogproject.domain.usecase.GetUserUseCase
import com.example.year4mobileprogproject.injection.DataSource
import com.example.year4mobileprogproject.injection.moviePost
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainViewModel(private val createUserUseCase: CreateUserUseCase,
                    private val getUserUseCase: GetUserUseCase
) : ViewModel(){

    var list: MutableLiveData<ArrayList<moviePost>> = MutableLiveData()
    val counter: MutableLiveData<Int> = MutableLiveData()

    init {
        counter.value = 0
    }

    suspend fun OnClickedIncrement(emailUser: String){

        viewModelScope.launch(Dispatchers.IO) { createUserUseCase.invoke(User("test"))
        }
       delay(1000)
        val user = getUserUseCase.invoke("test")

        //counter.value = (counter.value ?: 0) + 1

    }

    fun addDataSet(){
        list.value =  DataSource.createDataSet()//When you will add element in listData, the MainViewModel will tell the activity that something changed
    }

}