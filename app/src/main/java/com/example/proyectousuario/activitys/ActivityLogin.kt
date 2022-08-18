package com.example.proyectousuario.activitys


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectousuario.databinding.ActivityLoginBinding
import com.example.proyectousuario.user.entity.User
import com.example.proyectousuario.user.local.SharedPreferencesManager


class ActivityLogin :AppCompatActivity(){
    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        SharedPreferencesManager.getUser(this)?.let{
            val intent = Intent(this, ActivityHome::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()
            val user = User(username, password)
            SharedPreferencesManager.setUser(this, user)
        }

        binding.btnAtras.setOnClickListener {
            val intent:Intent = Intent(this, ActivityStart::class.java)
            startActivity(intent)
        }






    }

}

