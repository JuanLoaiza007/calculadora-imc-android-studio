package com.example.practica1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.practica1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    // onCreate es al Arrancar la pantalla
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        addBtnCalcularListener()
    }

    private fun calcularIMC(): Double? {
        try {
            val altura = binding.etAltura.text.toString().toDouble()
            val peso = binding.etPeso.text.toString().toDouble()
            return  peso / (altura * altura)
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Por favor, ingresa valores válidos", Toast.LENGTH_SHORT)
            return null
        }
    }

    private fun interpretarIMC(): String{
        val imc = calcularIMC() ?: return "---"

        return when {
            imc < 18.5 -> "Bajo peso"
            imc >= 18.5 && imc < 25 -> "Peso normal"
            imc >= 25 && imc < 30 -> "Sobrepeso"
            imc >= 30 -> "Obesidad"
            else -> "---"
        }
    }

    private fun addBtnCalcularListener(){
        binding.btnCalcular.setOnClickListener {
            binding.tvResultado.text = interpretarIMC()
        }
    }
}