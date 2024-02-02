package com.example.a18_bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a18_bmi.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    //Step 1
        private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateBtn.setOnClickListener {
            calculateBMI()
        }
    }
    //Step 2
    private fun calculateBMI(){
        val weight = binding.weightEdit.text.toString().toFloatOrNull()
        val height = binding.heightEdit.text.toString().toFloatOrNull()

        //Step 3
        if(weight!=null && height!=null){
            val bmi = weight/(height/100).pow(2)
            val bmiRes = String.format("%.2f",bmi)

            val bmiCategory = when {
                    bmi < 18.5 -> "Underweight"
                    bmi < 25 -> "Normal weight"
                    bmi < 30 -> "Overweight"
                    else -> "Obese"
            }
            binding.resultText.text = "BMI : $bmiRes\nCategory : $bmiCategory"
        }else{
            binding.resultText.text = "Enter Valid Input"
        }
    }

}


/*
*                          LOGIC
* Step 1 => Binding
* Step 2 => Create Calculate BMI Function
* Step 3 => BMI formula
* Step 4 => OP to Result
* Step 5 => call it on seOnsetFucntion
* */