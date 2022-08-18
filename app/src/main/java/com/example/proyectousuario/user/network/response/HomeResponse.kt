package com.example.proyectousuario.user.network.response

import com.example.proyectousuario.user.entity.Plate

data class HomeResponse(
    val info:Info,
    val recipes: List<Plate>
)

data class Info(
    val page: Int,
    val results:Int,
    val seed: String,
    val version: String
)