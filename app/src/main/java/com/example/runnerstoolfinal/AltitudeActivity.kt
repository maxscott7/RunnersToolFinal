package com.example.runnerstoolfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class AltitudeActivity : AppCompatActivity() {

    val distance = arrayOf(1500, 3000, 5000, 10000)
    val backButton: Button = findViewById(R.id.BackButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_altitude)

        val spinner = findViewById<Spinner>(R.id.spinnerD)
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, distance)
        spinner.adapter = arrayAdapter
        //spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener



        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


}