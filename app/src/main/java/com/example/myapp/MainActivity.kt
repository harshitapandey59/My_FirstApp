package com.example.myapp
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnadd: Button
    private lateinit var btnsub: Button
    private lateinit var btnmultiply: Button
    private lateinit var btndivide: Button
    private lateinit var et_a: EditText
    private lateinit var et_b: EditText
    private lateinit var resultTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnadd = findViewById(R.id.btn_add)
        btnsub = findViewById(R.id.btn_sub)
        btnmultiply = findViewById(R.id.btn_multiply)
        btndivide = findViewById(R.id.btn_divide)
        et_a = findViewById(R.id.et_a)
        et_b = findViewById(R.id.et_b)
        resultTv = findViewById(R.id.result_tv)

        btnadd.setOnClickListener(this)
        btnsub.setOnClickListener(this)
        btnmultiply.setOnClickListener(this)
        btndivide.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        try {
            val a = et_a.text.toString().toDouble()
            val b = et_b.text.toString().toDouble()
            var result = 0.0

            when (v?.id) {
                R.id.btn_add -> {
                    result = a + b
                }
                R.id.btn_sub -> {
                    result = a - b
                }
                R.id.btn_multiply -> {
                    result = a * b
                }
                R.id.btn_divide -> {
                    if (b != 0.0) {
                        result = a / b
                    } else {
                        resultTv.text = "Cannot divide by zero"
                        return
                    }
                }
            }

            resultTv.text = "Result is $result"
        } catch (e: NumberFormatException) {
            resultTv.text = "Please enter valid numbers"
        }
    }
}