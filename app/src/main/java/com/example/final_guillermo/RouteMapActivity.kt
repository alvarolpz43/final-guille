package com.example.final_guillermo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory

class RouteMapActivity : AppCompatActivity(), OnMapReadyCallback {


    private lateinit var map:GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_route_map)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        this.map = map
    }


    //fun getRetrofit():Retrofit{
       // return  Retrofit.Builder()
       //    .baseUrl("https://api.openrouteservice.org/")
        //    .addConverterFactory(GsonConverterFactory.create())
       //     .build()
      //  println("so")
  //  }

}
