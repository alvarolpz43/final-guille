package com.example.final_guillermo

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.final_guillermo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("Usuarios", Context.MODE_PRIVATE)

        binding.botonregister.setOnClickListener {
            val usu = binding.email.text.toString()
            val contra = binding.contraseA.text.toString()

            // Verificar si ya existe el usuario en SharedPreferences
            val usuarioExistente = sharedPreferences.getStringSet(usu, null)

            if (usuarioExistente == null) {
                // Si el usuario no existe, crear un nuevo conjunto de datos para él
                val newUserData = HashSet<String>()
                newUserData.add(usu)
                newUserData.add(contra)

                val editor = sharedPreferences.edit()
                editor.putStringSet(usu, newUserData)
                editor.apply()

                Toast.makeText(this, "¡Registro exitoso o q!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "El usuario ya está registrado o q", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
