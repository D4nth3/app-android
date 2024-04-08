package com.edu.eam.appprueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var texto:TextView
    lateinit var textoInicial:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        texto = findViewById<TextView>(R.id.texto_inicial)

        if(savedInstanceState != null){
            textoInicial = savedInstanceState.getString("texto").toString()
            texto.text = textoInicial
        }else{
            textoInicial = "Texto inicial"
            texto.text = textoInicial
        }

        Log.e("MainActivity", "onCreate()")
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("texto", textoInicial)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e("MainActivity", savedInstanceState.getString("texto").toString())
    }

    override fun onStart() {
        super.onStart()
        Log.e("MainActivity", "onPause()")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MainActivity", "onPause()")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity", "onResume()")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity", "onResume()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("MainActivity", "onRestart()")
    }
    fun irARegistro(v:View){
        val intent = Intent(this, RegistroActivity::class.java)
        startActivity(intent)
    }

    fun irALogin(v:View){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    fun irACrearLugar(v:View){
        val intent = Intent(this, CreatePlaceActivity ::class.java)
        startActivity(intent)
    }

    fun cambiarTexto(v:View){
        textoInicial = "Nuevo valor"
        texto.text = textoInicial
    }
}
