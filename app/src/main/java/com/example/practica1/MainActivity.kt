package com.example.practica1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // onCreate es al Arrancar la pantalla
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obteniendo de la interfaz
        val etAltura: EditText = findViewById(R.id.etAltura)
        val etPeso: EditText = findViewById(R.id.etPeso)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val tvResultado: TextView = findViewById(R.id.tvResultado)

        fun calcularIMC(altura: Double?, peso: Double?): String {
            if (altura == null || altura <= 0) {
                return "Error, la altura no es válida"
            }
            if (peso == null || peso <= 0) {
                return "Error, el peso no es válido"
            }

            val imc = peso / (altura * altura)

            return when {
                imc < 18.5 -> "Bajo peso"
                imc >= 18.5 && imc < 25 -> "Peso normal"
                imc >= 25 && imc < 30 -> "Sobrepeso"
                imc >= 30 -> "Obesidad"
                else -> "Error"
            }
        }

        btnCalcular.setOnClickListener {
            val altura = etAltura.text.toString().toDoubleOrNull()
            val peso = etPeso.text.toString().toDoubleOrNull()
            tvResultado.text = calcularIMC(altura, peso)
        }
    }
}