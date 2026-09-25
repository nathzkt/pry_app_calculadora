package com.example.pry_app_calculadora.Vista

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pry_app_calculadora.Presentador.clsCalculadoraPresenter
import com.example.pry_app_calculadora.R

class MainActivity : AppCompatActivity() {

    private lateinit var txtNum1: EditText
    private lateinit var txtNum2: EditText

    private lateinit var btnSumar: Button
    private lateinit var btnRestar: Button
    private lateinit var btnMultiplicar: Button
    private lateinit var btnDividir: Button

    private lateinit var txtResultado: TextView

    private lateinit var presenter: clsCalculadoraPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)

        btnSumar = findViewById(R.id.btnSumar)
        btnRestar = findViewById(R.id.btnRestar)
        btnMultiplicar = findViewById(R.id.btnMultiplicar)
        btnDividir = findViewById(R.id.btnDividir)

        txtResultado = findViewById(R.id.txtResultado)

        presenter = clsCalculadoraPresenter(this)

        btnSumar.setOnClickListener(this::ejecutarAccionSumar)
        btnRestar.setOnClickListener(this::ejecutarAccionRestar)
        btnMultiplicar.setOnClickListener(this::ejecutarAccionMultiplicar)
        btnDividir.setOnClickListener(this::ejecutarAccionDividir)
    }
    private fun ejecutarAccionSumar(v: View) {
        presenter.Sumar(
            txtNum1.text.toString(),
            txtNum2.text.toString()
        )
    }

    private fun ejecutarAccionRestar(v: View) {
        presenter.Restar(
            txtNum1.text.toString(),
            txtNum2.text.toString()
        )
    }

    private fun ejecutarAccionMultiplicar(v: View) {
        presenter.Multiplicar(
            txtNum1.text.toString(),
            txtNum2.text.toString()
        )
    }

    private fun ejecutarAccionDividir(v: View) {
        presenter.Dividir(
            txtNum1.text.toString(),
            txtNum2.text.toString()
        )
    }

    fun mostrarResultado(resultado: String) {
        txtResultado.text = resultado
    }

}