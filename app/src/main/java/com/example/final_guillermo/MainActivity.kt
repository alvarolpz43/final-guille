package com.example.final_guillermo

import android.content.Context
import android.content.Intent
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

        sharedPreferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE)

        binding.botonregister.setOnClickListener {
            val usu = binding.email.text.toString()
            val contra = binding.contraseA.text.toString()

            // Verificar si el usuario y la contraseña coinciden con los guardados
            val usuarioGuardado = sharedPreferences.getString("nombre_usuario", usu)
            val contrasenaGuardada = sharedPreferences.getString("contrasena", contra)

            if (usu == usuarioGuardado && contra == contrasenaGuardada) {
                val intent = Intent(this, RouteMapActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }

        // Si deseas implementar el registro de usuarios, podrías hacerlo aquí
        // Al hacer clic en un botón de registro o mediante otro método
        // Guardarías los datos ingresados en los campos de texto en SharedPreferences
        // por ejemplo, al registrar:
        /*
        binding.buttonRegister.setOnClickListener {
            val nombreUsuario = binding.email.text.toString()
            val contrasena = binding.contraseA.text.toString()

            val editor = sharedPreferences.edit()
            editor.putString("nombre_usuario", nombreUsuario)
            editor.putString("contrasena", contrasena)
            editor.apply()
        }
        */
    }
}
