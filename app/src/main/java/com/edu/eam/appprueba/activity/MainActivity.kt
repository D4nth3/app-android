package com.edu.eam.appprueba.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import com.edu.eam.appprueba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textSearch.setOnEditorActionListener{ textView, i, keyEvent ->
            if(i == EditorInfo.IME_ACTION_SEARCH){

                val search = binding.textSearch.text.toString()

                if(search.isNotEmpty()){
                    val intent = Intent(baseContext, SearchResultActivity::class.java)
                    intent.putExtra("texto", search)
                    startActivity(intent)
                }
            }
            true
        }
    }

    fun createPlace(v:View){
        val intent = Intent(this, CreatePlaceActivity::class.java)
        startActivity(intent)
    }



}
