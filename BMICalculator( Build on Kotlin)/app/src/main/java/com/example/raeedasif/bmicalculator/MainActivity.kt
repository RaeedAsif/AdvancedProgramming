package com.example.raeedasif.bmicalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button : Button = findViewById(R.id.button)
        button.setOnClickListener{

            val weightT : EditText = findViewById(R.id.WeightT)
            val heightT : EditText = findViewById(R.id.heightT)
            val text : TextView = findViewById(R.id.bmiT)
            val w: Float = weightT.text.toString().toFloat()
            val h: Float = heightT.text.toString().toFloat()

            val x: Float = w/h
            text.text = "Your BMI is " + x/h
        }
    }

}
