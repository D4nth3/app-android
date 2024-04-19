 package com.edu.eam.appprueba.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.edu.eam.appprueba.adapter.PlaceAdapter
import com.edu.eam.appprueba.bd.Places
import com.edu.eam.appprueba.databinding.ActivitySearchResultBinding
import com.edu.eam.appprueba.model.Place

 class SearchResultActivity : AppCompatActivity() {

    lateinit var binding: ActivitySearchResultBinding
    var searchText:String = ""
    lateinit var placesList:ArrayList<Place>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        searchText = intent.extras!!.getString("texto", "")
        placesList = ArrayList()

        if(searchText.isNotEmpty()){
            placesList = Places.searchName(searchText)
            Log.e("SearchResultActivity", placesList.toString())

        }

        val adapter = PlaceAdapter(placesList)
        binding.placeList.adapter = adapter
        binding.placeList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }
}