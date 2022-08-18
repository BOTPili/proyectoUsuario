package com.example.proyectousuario.activitys

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.proyectousuario.databinding.ActivityStartBinding

class ActivityStart : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btStartLogin.setOnClickListener {
            val intent:Intent = Intent(this, ActivityLogin::class.java)
            startActivity(intent)
        }

    }
}


