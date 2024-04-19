package com.edu.eam.appprueba.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.edu.eam.appprueba.R
import com.edu.eam.appprueba.bd.Places
import com.edu.eam.appprueba.databinding.ActivityDetailPlaceBinding

class DetailPlaceActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailPlaceBinding
    var placeCode:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailPlaceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        placeCode = intent.extras!!.getInt("codigo")

        val place = Places.get(placeCode)

        Toast.makeText(this, "${place.toString()}", Toast.LENGTH_LONG).show()
    }
}