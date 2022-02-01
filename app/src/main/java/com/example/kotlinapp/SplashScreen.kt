package com.example.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        gotoHomeScreen()
    }


    private fun gotoHomeScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
           val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
        }, 3000)
    }
}