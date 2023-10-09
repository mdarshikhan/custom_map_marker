package com.mak.app.custommapmarker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.mak.app.custommapmarker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mGoogleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun setListeners() {
        binding.btnMarkerOnly.setOnClickListener {
            if (mGoogleMap != null) {
                if (this@MainActivity::mGoogleMap.isInitialized) {
                    setCustomMarker()
                }
            }

        }
    }

    private fun setCustomMarker() {
        val sydney = LatLng(-34.0, 151.0)

        val blackMarkerIcon : BitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.ic_black_marker)

        val markerOptions : MarkerOptions = MarkerOptions()
            .position(sydney)
            .title("Title Of Marker")
            .snippet("Snippet content")
            .icon(blackMarkerIcon)

        mGoogleMap.addMarker(markerOptions)
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onMapReady(map: GoogleMap) {
        mGoogleMap = map
    }
}