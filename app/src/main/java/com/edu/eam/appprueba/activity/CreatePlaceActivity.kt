package com.edu.eam.appprueba.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.edu.eam.appprueba.R
import com.edu.eam.appprueba.bd.Categories
import com.edu.eam.appprueba.bd.Citys
import com.edu.eam.appprueba.bd.Places
import com.edu.eam.appprueba.databinding.ActivityCreatePlaceBinding
import com.edu.eam.appprueba.model.Category
import com.edu.eam.appprueba.model.City
import com.edu.eam.appprueba.model.Place

class CreatePlaceActivity : AppCompatActivity() {

    lateinit var binding: ActivityCreatePlaceBinding
    var positionCity: Int = -1
    var positionCategory: Int = -1
    lateinit var citys:ArrayList<City>
    lateinit var categories:ArrayList<Category>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreatePlaceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        citys = Citys.list()
        categories = Categories.list()
        loadCitys()
        loadCategories()

        binding.btnCreatePlace.setOnClickListener{craatePlace()}

    }

    fun loadCitys(){
        var list = Citys.list().map { c -> c.name }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.cityPlace.adapter = adapter

        binding.cityPlace.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                positionCity = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

    }

    fun loadCategories(){
        var list = Categories.list().map { c -> c.name }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.categoryPlace.adapter = adapter

        binding.categoryPlace.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                positionCategory = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

    }

    fun craatePlace(){

        val name = binding.namePlace.text.toString()
        val description = binding.descriptionPlace.text.toString()
        val direction = binding.descriptionPlace.text.toString()
        val idCity = citys[positionCity].id
        val idCategory = categories[positionCategory].id
        val phone = binding.phonePlace.text.toString()

        if(name.isEmpty()){
            binding.nameLayout.error = getString(R.string.es_obligatorio)
        }else{
            binding.nameLayout.error = null
        }

        if(description.isEmpty()){
            binding.descriptionLayout.error = getString(R.string.es_obligatorio)
        }else{
            binding.descriptionLayout.error = null
        }

        if(direction.isEmpty()){
            binding.directionLayout.error = getString(R.string.es_obligatorio)
        }else{
            binding.directionLayout.error = null
        }

        if(phone.isEmpty()){
            binding.phoneLayout.error = getString(R.string.es_obligatorio)
        }else{
            binding.phoneLayout.error = null
        }

        if(name.isNotEmpty() && description.isNotEmpty() && direction.isNotEmpty() && idCity != -1 && idCategory != -1 && phone.isNotEmpty()){
            val newPLace = Place(6, name, description, 2, false, idCategory, direction,0f, 0f, idCity)

            val phones: ArrayList<String> = ArrayList()
            phones.add(phone)

            newPLace.phones = phones

            Places.create(newPLace)
        }

    }
}