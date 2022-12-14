package com.example.runnerstoolfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class TreadmillActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treadmill)
        val calculateMPH: Button = findViewById(R.id.treadCalculate)
        val mins: EditText = findViewById(R.id.minutes)
        val sec: EditText = findViewById(R.id.seconds)
        val result: TextView = findViewById(R.id.mph)
        val backButton: Button = findViewById(R.id.BackButton)
        calculateMPH.setOnClickListener {
            val total = 3600 / ((mins.text.toString().toInt() * 60) + sec.text.toString().toInt()).toDouble()
            result.visibility = View.VISIBLE
            result.setText(total.toString() + " mph")
        }
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}