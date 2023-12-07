package com.example.final_guillermo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.final_guillermo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonregister.setOnClickListener {
             val usu= binding.email.text.toString()
            val contra= binding.contraseA.text.toString()

            if(usu=="aldair@gmail.com" && contra=="123456"){
                val intent= Intent(this ,RouteMapActivity ::class.java)

                startActivity(intent)
                finish()
            } else{
                Toast.makeText(this, "credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }



        }
    }
}