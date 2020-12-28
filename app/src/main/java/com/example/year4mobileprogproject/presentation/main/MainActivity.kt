package com.example.year4mobileprogproject.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.year4mobileprogproject.MovieRecyclerAdapter
import com.example.year4mobileprogproject.R
import com.example.year4mobileprogproject.TopSpacingItemDecoration
import com.example.year4mobileprogproject.injection.DataSource
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var movieAdapter: MovieRecyclerAdapter
    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.onStart()


        initRecyclerView()
        addDataSet()
    }

    private fun addDataSet(){
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
