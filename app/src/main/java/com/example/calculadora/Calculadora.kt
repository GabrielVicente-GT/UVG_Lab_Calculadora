package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import org.w3c.dom.Text
import java.lang.Exception

class Calculadora : AppCompatActivity() {

    lateinit var txtResultado: TextView
    lateinit var txtOperacion: TextView
    lateinit var cero: Button
    lateinit var uno: Button
    lateinit var dos: Button
    lateinit var tres: Button
    lateinit var cuatro: Button
    lateinit var cinco: Button
    lateinit var seis: Button
    lateinit var siete: Button
    lateinit var ocho: Button
    lateinit var nueve: Button

    lateinit var sumar:Button
    lateinit var restar:Button
    lateinit var multiplicar:Button
    lateinit var dividir:Button
    lateinit var operar:Button
    lateinit var borrando:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        txtResultado = findViewById(R.id.finalizando)
        txtOperacion = findViewById(R.id.expresion)
        cero = findViewById(R.id.cero)
        uno = findViewById(R.id.uno)
        dos= findViewById(R.id.dos)
        tres = findViewById(R.id.tres)
        cuatro = findViewById(R.id.cuatro)
        cinco = findViewById(R.id.cinco)
        seis = findViewById(R.id.seis)
        siete = findViewById(R.id.siete)
        ocho = findViewById(R.id.ocho)
        nueve = findViewById(R.id.nueve)

        sumar = findViewById(R.id.sumando)
        restar = findViewById(R.id.restando)
        multiplicar = findViewById(R.id.multiplicando)
        dividir = findViewById(R.id.dividiendo)
        operar = findViewById(R.id.igual)

        borrando = findViewById(R.id.borrando)

        uno.setOnClickListener{ calculando("1",true)}
        dos.setOnClickListener{ calculando("2",true)}
        tres.setOnClickListener{ calculando("3",true)}
        cuatro.setOnClickListener{ calculando("4",true)}
        cinco.setOnClickListener{ calculando("5",true)}
        seis.setOnClickListener{ calculando("6",true)}
        siete.setOnClickListener{ calculando("7",true)}
        ocho.setOnClickListener{ calculando("8",true)}
        nueve.setOnClickListener{ calculando("9",true)}
        cero.setOnClickListener{ calculando("0",true)}

        sumar.setOnClickListener{ calculando("+",true)}
        restar.setOnClickListener{ calculando("-",true)}
        multiplicar.setOnClickListener{ calculando("*",true)}
        dividir.setOnClickListener{ calculando("/",true)}


        borrando.setOnClickListener{
            txtOperacion.text=""
        txtResultado.text=""}

        operar.setOnClickListener{
            try {
                val polinomio = ExpressionBuilder(txtOperacion.text.toString()).build()
                val terminando = polinomio.evaluate()
                val resultado_largo = terminando.toLong()
                if (terminando==resultado_largo.toDouble()){
                    txtResultado.text = resultado_largo.toString()
                }else{
                    txtResultado.text = terminando.toString()
                }
                txtOperacion.text=""
            }catch (e:Exception){

            }
        }
    }

    fun calculando(string:String,borrandoa:Boolean){
        if (borrandoa){
            txtResultado.text = ""
            txtOperacion.append(string)
        }else{
            txtOperacion.append(txtResultado.text)
            txtOperacion.append(string)
            txtResultado.text = ""
        }

    }
}