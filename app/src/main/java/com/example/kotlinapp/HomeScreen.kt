package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.fragments.BooksFragment
import com.example.fragments.ContactFragment
import com.example.fragments.HomeFragment
import com.example.models.AuthorModel
import com.example.networkservice.ApiService
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeScreen : AppCompatActivity() {

    lateinit var bottomNavigation:BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        findViews()
        setFragment(HomeFragment())

        bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeNav->setFragment(HomeFragment())
                R.id.booksNav->setFragment(BooksFragment())
                R.id.contactNav->setFragment(ContactFragment())
            }
            true

        }

    }


    private fun findViews(){
        bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
    }


    private fun setFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout,fragment).commit()
        }
    }
}