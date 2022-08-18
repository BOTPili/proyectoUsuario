package com.example.proyectousuario.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectousuario.databinding.ActivityDetailBinding

class ActivityDetail : AppCompatActivity() {
   private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            val intent: Intent = Intent(this, ActivityHome::class.java)
            startActivity(intent)
        }

    }
}