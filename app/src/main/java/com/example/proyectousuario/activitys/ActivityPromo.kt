package com.example.proyectousuario.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectousuario.adapters.PlateAdapter
import com.example.proyectousuario.databinding.ActivityPromocionesBinding

import com.example.proyectousuario.user.entity.getPlaceHolderItems

class ActivityPromo : AppCompatActivity() {
    private lateinit var binding: ActivityPromocionesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPromocionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener{
            val intent: Intent = Intent(this,ActivityHome::class.java)
            startActivity(intent)
        }

        val adapter = PlateAdapter(getPlaceHolderItems(this))
        binding.rvPlate.adapter = adapter
        binding.rvPlate.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
    }
}