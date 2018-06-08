package com.example.gabriel.fourfunctioncalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_function_results_screen.*
import java.text.DecimalFormat
import android.content.Intent

class FunctionResultsScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function_results_screen)

        showResult()
        setCheckAgainListener()
        setExitListener()
    }

    fun showResult(){
        var decFormat = DecimalFormat("#.#")
        var formattedResult = decFormat.format(getIntent().getExtras().getDouble("FunctionResult"))
        lblResult.setText(formattedResult.toString())
    }

    fun setExitListener(){
        btnExit.setOnClickListener{
            this.finishAffinity()
        }
    }

    fun setCheckAgainListener(){
        btnBack.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}


