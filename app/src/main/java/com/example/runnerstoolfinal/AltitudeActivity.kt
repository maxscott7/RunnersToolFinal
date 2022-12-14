package com.example.runnerstoolfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*

class AltitudeActivity : AppCompatActivity() {

    val distance = arrayOf(1500, 3000, 5000, 10000)
    val backButton: Button = findViewById(R.id.BackButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_altitude)

        val mins: EditText = findViewById(R.id.minutes)
        val sec: EditText = findViewById(R.id.seconds)
        val altitude: EditText = findViewById(R.id.altitude)
        val result: TextView = findViewById(R.id.altProduct)
        val calculateAlt: Button = findViewById(R.id.altCalculate)

        calculateAlt.setOnClickListener {
            val total = ((mins.text.toString().toInt() * 60) + sec.text.toString().toInt()) - (altitude.text.toString().toInt() / 500)
            result.visibility = View.VISIBLE
            result.setText(total.toString() + " seconds")
        }

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


}