package com.example.year4mobileprogproject.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.year4mobileprogproject.domain.entity.User
import com.example.year4mobileprogproject.domain.usecase.CreateUserUseCase
import com.example.year4mobileprogproject.domain.usecase.GetUserUseCase
import com.example.year4mobileprogproject.injection.DataSource
import com.example.year4mobileprogproject.injection.androidTutoPost
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){

    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()

    var list: MutableLiveData<ArrayList<androidTutoPost>> = MutableLiveData()

    fun onStart(emailUser: String){
        viewModelScope.launch(Dispatchers.IO) {
            createUserUseCase.invoke(User("test"))
            delay(1000)
            val user = getUserUseCase.invoke("test")
        }


        list.value = DataSource.createDataSet() //When you will add element in listData, the MainViewModel will tell the activity that something changed
    }

    fun OnClickedLogin(emailUser: String, password: String){

        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser)
            //createUserUseCase.invoke(User("test"))
            //val user: User = getUserUseCase.invoke("test")
            val loginStatus = if(user != null){

                loginSuccess(user.email)

            }else{
                loginError
            }
            withContext(Dispatchers.IO){
                loginLiveData.value = loginStatus

            }
        }
    }
}