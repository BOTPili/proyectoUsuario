package com.example.proyectousuario.activitys

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectousuario.R
import com.example.proyectousuario.adapters.HomeItemAdapter
import com.example.proyectousuario.databinding.ActivityHomeBinding
import com.example.proyectousuario.user.entity.Plate
import com.example.proyectousuario.user.entity.getPlaceHolderItems
import com.example.proyectousuario.user.network.ApiClient
import com.example.proyectousuario.user.network.response.HomeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ActivityHome :AppCompatActivity(){
    private lateinit var binding:ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnVerMas.setOnClickListener {
            val intent:Intent = Intent(this,ActivityPromo::class.java)
            startActivity(intent)
        }


        findViewById<View>(R.id.btn_promo).setOnClickListener {
            val intent:Intent = Intent(this,ActivityPromo::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.btn_ver_mas).setOnClickListener {
            val intent:Intent = Intent(this,ActivityDetail::class.java)
            startActivity(intent)
            finish()
        }

    }
     private fun getRecipes(){
         val fieldToInclude = "limitLicense, tags, number"
         val resultsQuantity = 5
         val service = ApiClient.getServiceClient()
         val call = service.getRecipes(fieldToInclude,resultsQuantity)
         val callback = object: Callback<HomeResponse>{
             override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
                 if(response.isSuccessful){
                     response.body()?.let{
                         val recipesList = it.recipes
                         setRecipesList(recipesList)
                     }
                 }
             }
             override fun onFailure(call: Call<HomeResponse>, t: Throwable) {

             }
         }
       call.enqueue(callback)

    }

    private fun setRecipesList(recipes:List<Plate>){
        val adapter = HomeItemAdapter(getPlaceHolderItems(this))
        binding.rvHome.adapter = adapter
        binding.rvHome.layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

    }

}



