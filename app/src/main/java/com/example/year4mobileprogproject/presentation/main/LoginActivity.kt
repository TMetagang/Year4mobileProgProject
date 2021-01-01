package com.example.year4mobileprogproject.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.year4mobileprogproject.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.login_activity.*
import org.koin.android.ext.android.inject


class LoginActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        mainViewModel.loginLiveData.observe(this, Observer {
            when (it) {
                is loginSuccess -> {
                    //TODO Navigate
                }

                loginError -> {
            MaterialAlertDialogBuilder(this)
                        .setTitle("Erreur")
                .setMessage("Compte Incorrect")
                        .setPositiveButton("Ok") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })

    login_button.setOnClickListener {
        mainViewModel.OnClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())
        startActivity(Intent( this, MainActivity::class.java))
    }

        create_account_button.setOnClickListener {
            startActivity(Intent( this, MainActivity::class.java))
        }
    }
}