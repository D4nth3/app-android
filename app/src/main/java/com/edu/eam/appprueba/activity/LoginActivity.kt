package com.edu.eam.appprueba.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.edu.eam.appprueba.R
import com.edu.eam.appprueba.bd.Users
import com.edu.eam.appprueba.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{login()}

    }

    fun login(){
        val email = binding.emailUser.text
        var password = binding.passwordUser.text

        if(email.isEmpty()){
            binding.emailLayout.error = getString(R.string.es_obligatorio)
        }else{
            binding.emailLayout.error = null
        }

        if(password.isEmpty()){
            binding.passwordLayout.error = getString(R.string.es_obligatorio)
        }else{
            binding.passwordLayout.error = null
        }

        if(email.isNotEmpty() && password.isNotEmpty()){

             try {
                 val user = Users.login(email.toString(), password.toString())
                 Toast.makeText(this, getString(R.string.datos_correctos), Toast.LENGTH_SHORT).show()
                 val intent = Intent(this, MainActivity::class.java)
                 startActivity(intent)
             }catch (e:Exception){
                 Toast.makeText(this, getString(R.string.datos_incorrectos), Toast.LENGTH_SHORT).show()
             }
        }
    }
}