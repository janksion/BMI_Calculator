package com.example.bmicalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            btnCalculate.setOnClickListener() {
                try {
                val height = txtHeight.text.toString().toDouble()
                val weight = txtWeight.text.toString().toDouble()
                val BMI:Double = calculateBMT(height, weight)

                if (BMI < 18.5) {
                    BMIimage.setImageResource(R.drawable.under)
                    lblBMIResult.text = "BMI Result : " + (String.format("%.2f", BMI) + " (Under)")
                } else if (BMI >= 18.5 && BMI <= 24.9) {
                    BMIimage.setImageResource(R.drawable.normal)
                    lblBMIResult.text = "BMI Result : " + (String.format("%.2f", BMI) + " (Normal)")
                } else if (BMI > 24.9) {
                    BMIimage.setImageResource(R.drawable.over)
                    lblBMIResult.text = "BMI Result : " + (String.format("%.2f", BMI) + " (Over)")
                } else {
                    BMIimage.setImageResource(R.drawable.empty)
                    lblBMIResult.text = ""
                }

                Toast.makeText(applicationContext, "Calculate Completed!", Toast.LENGTH_SHORT).show()

                } catch (e:Exception) {
                    Toast.makeText(applicationContext, "Please input value", Toast.LENGTH_SHORT).show()
                }
            }

        btnReset.setOnClickListener() {
            lblBMIResult.text = ""
            txtHeight.text.clear()
            txtWeight.text.clear()
            BMIimage.setImageResource(R.drawable.empty)
        }
    }

    private fun calculateBMT(height: Double, weight: Double): Double {
        return weight / (height * height)
    }
}
