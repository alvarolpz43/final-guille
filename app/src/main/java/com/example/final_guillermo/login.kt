package com.example.final_guillermo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.final_guillermo.databinding.ActivityLoginBinding
import com.example.final_guillermo.databinding.ActivityMainBinding

class login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var btnLogin= binding.btnLogin
        var btnRegister= binding.btnRegister

        btnLogin.setOnClickListener {

            val email= binding.email.text.toString()
            val password= binding.password.text.toString()

            if (email=="map" && password=="123"){
                val intent: Intent= Intent(this, RouteMapActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Welcome to Map", Toast.LENGTH_SHORT).show()

            }
            else{
                Toast.makeText(this, "Email or password incorrect", Toast.LENGTH_SHORT).show()
            }




        }


    }
}