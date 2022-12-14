package com.example.runnerstoolfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val treadFrag = treadmillFragment()
        val treadmillBtn: Button = findViewById(R.id.treadmillButton)
        val trackFrag = trackFragment()
        val trackBtn: Button = findViewById(R.id.trackButton)


        treadmillBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.treadmillFL, treadFrag)
                commit()
            }
        }

        trackBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.treadmillFL, trackFrag)
                commit()
            }

        }


    }
}