package com.example.gabriel.fourfunctioncalculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnClickListenerForCalculate()
    }

    private fun calculateFunction():Double{
        var number1: Double = (firstNum.getText().toString().toDouble())
        var number2: Double = (secondNum.getText().toString().toDouble())
        var total: Double = 0.0
        var function = setOnClickListenerForFunction()

        when (function){
            "/" -> total = (number1 / number2)
            "*" -> total = (number1*number2)
            "+" -> total = (number1+number2)
            "-" -> total = (number1-number2)
        }
        return total
    }

    private fun setOnClickListenerForCalculate(){
        btnCalculate.setOnClickListener {
            val intent = Intent (this, FunctionResultsScreen::class.java)
            intent.putExtra("FunctionResult",calculateFunction())
            startActivity(intent)
        }
    }

    private fun setOnClickListenerForFunction(): String{
        var function: String = ""

        btnDiv.setOnClickListener{
            function = "/"
        }
        btnMult.setOnClickListener{
            function = "*"
        }
        btnPlus.setOnClickListener{
            function = "+"
        }
        btnMin.setOnClickListener{
            function = "-"
        }

        return function
    }
}
