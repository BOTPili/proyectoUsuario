package com.example.proyectousuario.activitys

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectousuario.databinding.ActivitySignupBinding
import com.example.proyectousuario.user.entity.User
import com.example.proyectousuario.user.local.SharedPreferencesManager

class ActivitySignUp:AppCompatActivity() {
    private lateinit var binding:ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSingUp.setOnClickListener {
            val intent: Intent = Intent(this,ActivityHome::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnAtras.setOnClickListener {
            val intent: Intent = Intent(this, ActivityStart::class.java)
            startActivity(intent)

        }

    }
}