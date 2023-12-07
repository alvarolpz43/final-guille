package com.example.final_guillermo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import com.example.final_guillermo.databinding.ActivitySplashBinding

class Splash : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val SPLASH_TIME_OUT: Long = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.in
        setContentView(binding.root)

        Handler().postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

            finish()
        },SPLASH_TIME_OUT)
    }
}