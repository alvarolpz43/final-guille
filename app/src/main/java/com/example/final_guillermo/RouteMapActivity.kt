package com.example.final_guillermo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RouteMapActivity : AppCompatActivity(), OnMapReadyCallback {


    private lateinit var map: GoogleMap
    private lateinit var btnCalculate: Button
    private var start: String = ""
    private var end: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_route_map)

        btnCalculate = findViewById(R.id.btnCalculateRoute)
        btnCalculate.setOnClickListener {
            start = ""
            end = ""

            if (::map.isInitialized) {
                map.setOnMapClickListener {
                    if (start.isEmpty()) {
                        start = "${it.longitude},${it.latitude}"
                    } else if (end.isEmpty()) {
                        end = "${it.longitude},${it.latitude}"
                        createRoute()
                    }
                }
            }
        }

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        this.map = map
    }

    fun createRoute() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(ApiService::class.java)
                .getRoute("5b3ce3597851110001cf6248c50b947f1222418498fae123bb1a6114", start,end)
            if (call.isSuccessful){
                Log.i("aris","OK")
            }else{
                Log.i("aris","OK")
            }
        }
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.openrouteservice.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //  println("so")
    }

}

