package com.example.proyectousuario.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectousuario.databinding.ItemPlateHomeBinding
import com.example.proyectousuario.user.entity.Plate

class HomeItemAdapter(var items: List<Plate>) : RecyclerView.Adapter<HomeItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemPlateHomeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount(): Int = items.size


    class ViewHolder(private val binding:ItemPlateHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(plate: Plate) {
            binding.tvName.text = plate.sourceName
            binding.tvPrice.text = plate.pricePerServing.toString()
            plate.image.let { binding.ivPlateImage }
        }
    }
}