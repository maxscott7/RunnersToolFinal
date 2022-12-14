package com.example.runnerstoolfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_track.*

class TrackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track)

        val calculateSplit: Button = findViewById(R.id.trackCalculate)
        val mins: EditText = findViewById(R.id.raceMinutes)
        val sec: EditText = findViewById(R.id.raceSeconds)
        val distance: EditText = findViewById(R.id.raceDistance)
        val splitDistance: EditText = findViewById((R.id.splitDistance))
        val backButton: Button = findViewById(R.id.BackButton)
        val result: TextView = findViewById(R.id.splitTime)

        calculateSplit.setOnClickListener {
            val total = ((((mins.text.toString().toDouble() * 60) + sec.text.toString().toDouble()) / distance.text.toString().toDouble()) * splitDistance.text.toString().toDouble())
            result.visibility = View.VISIBLE
            result.setText(total.toString() + " seconds per split")
        }

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}