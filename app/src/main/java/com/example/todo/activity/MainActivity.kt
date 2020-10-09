package com.example.todo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.todo.R

class MainActivity : AppCompatActivity() {

    lateinit var navCont : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navCont = Navigation.findNavController(this, R.id.nav_host)
    }
}
