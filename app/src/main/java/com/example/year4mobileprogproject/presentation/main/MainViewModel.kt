package com.example.year4mobileprogproject.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.year4mobileprogproject.MovieRecyclerAdapter
import com.example.year4mobileprogproject.TopSpacingItemDecoration
import com.example.year4mobileprogproject.domain.entity.User
import com.example.year4mobileprogproject.domain.usecase.CreateUserUseCase
import com.example.year4mobileprogproject.injection.DataSource
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch


class MainViewModel(private val createUserUseCase: CreateUserUseCase) : ViewModel(){

    private lateinit var movieAdapter: MovieRecyclerAdapter


    val counter: MutableLiveData<Int> = MutableLiveData()

    init {
        counter.value = 0
    }

    fun OnClickedIncrement(emailUser: String){

        viewModelScope.launch { createUserUseCase.invoke(User(emailUser))
        }

        //counter.value = (counter.value ?: 0) + 1

    }

    fun addDataSet(){
        val data =
            DataSource.createDataSet()
        movieAdapter.submitList(data)
    }

    private fun initRecyclerView(){

        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingItemDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingItemDecoration)
            movieAdapter = MovieRecyclerAdapter()
            adapter = movieAdapter

        }

    }


}