package com.edu.eam.appprueba.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.edu.eam.appprueba.R
import com.edu.eam.appprueba.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun goToRegister(v: View){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun goToLogin(v:View){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}