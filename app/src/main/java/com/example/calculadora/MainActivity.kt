package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalculadora: Button = findViewById(R.id.btnCalculadora)

        btnCalculadora.setOnClickListener{
            val intent: Intent= Intent(this,Calculadora::class.java)
            startActivity(intent)
            finish()
        }

    }


}