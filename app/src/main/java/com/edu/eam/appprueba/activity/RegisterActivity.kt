package com.edu.eam.appprueba.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.edu.eam.appprueba.R
import com.edu.eam.appprueba.bd.Users
import com.edu.eam.appprueba.databinding.ActivityRegisterBinding
import com.edu.eam.appprueba.model.User

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener{(registerUser())}
    }
    fun registerUser(){

        val name = binding.nameUser.text.toString()
        val nickname = binding.nicknameUser.text.toString()
        val email = binding.emailUser.text.toString()
        val password = binding.passwordUser.text.toString()

        if(name.isEmpty()){
            binding.nameLayout.error = getString(R.string.es_obligatorio)
        }else{
            binding.nameLayout.error = null
        }

        if(nickname.isEmpty()){
            binding.nicknameLayout.error = getString(R.string.es_obligatorio)
        }else{
            if(nickname.length > 10){
                binding.nicknameLayout.error = getString(R.string.maximo_caracteres)
            }else{
                binding.nicknameLayout.error = null
            }

        }

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

        if (name.isNotEmpty() && nickname.isNotEmpty() && nickname.length<=10 && email.isNotEmpty() && password.isNotEmpty()){

            val user = User(4, name, nickname, email, password)
            Users.add(user)

            Toast.makeText(this, getString(R.string.usuario_registrado), Toast.LENGTH_SHORT).show()
        }

    }
}