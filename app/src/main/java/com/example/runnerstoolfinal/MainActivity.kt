package com.example.runnerstoolfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val treadmillBtn: Button = findViewById(R.id.treadmillButton)
        val altBtn: Button = findViewById(R.id.altButton)
        val trackBtn: Button = findViewById(R.id.trackButton)
        val trainingBtn: Button = findViewById(R.id.trainingButton)


        treadmillBtn.setOnClickListener {
            val intent = Intent(this, TreadmillActivity::class.java)
            startActivity(intent)
        }

        altBtn.setOnClickListener {
            val intent = Intent(this, AltitudeActivity::class.java)
            startActivity(intent)
        }

        trackBtn.setOnClickListener {
            val intent = Intent(this, TrackActivity::class.java)
            startActivity(intent)
        }

        trainingBtn.setOnClickListener {
            val intent = Intent(this, TrainingActivity::class.java)
            startActivity(intent)
        }


    }
}