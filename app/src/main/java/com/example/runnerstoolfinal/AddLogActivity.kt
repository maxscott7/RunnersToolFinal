package com.example.runnerstoolfinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import java.text.SimpleDateFormat
import java.util.*

class AddLogActivity : AppCompatActivity() {

    lateinit var logTitleEdt: EditText
    lateinit var logEdt: EditText
    lateinit var saveBtn: Button
    lateinit var viewModal: logViewModal
    var logID = -1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_log)

        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(logViewModal::class.java)

        logTitleEdt = findViewById(R.id.idEdtlogName)
        logEdt = findViewById(R.id.idEdtlogDesc)
        saveBtn = findViewById(R.id.idBtn)

        val logType = intent.getStringExtra("logType")
        if (logType.equals("Edit")) {
            val logTitle = intent.getStringExtra("logTitle")
            val logDescription = intent.getStringExtra("logDescription")
            logID = intent.getIntExtra("logId", -1)
            saveBtn.setText("Update Log")
            logTitleEdt.setText(logTitle)
            logEdt.setText(logDescription)
        } else {
            saveBtn.setText("Save Log")
        }

        saveBtn.setOnClickListener {
            val logTitle = logTitleEdt.text.toString()
            val logDescription = logEdt.text.toString()

            if (logType.equals("Edit")) {
                if (logTitle.isNotEmpty() && logDescription.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val currentDateAndTime: String = sdf.format(Date())
                    val updatedLog = Log(logTitle, logDescription, currentDateAndTime)
                    updatedLog.id = logID
                    viewModal.updatelog(updatedLog)
                    Toast.makeText(this, "Log Updated..", Toast.LENGTH_LONG).show()
                }
            } else {
                if (logTitle.isNotEmpty() && logDescription.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val currentDateAndTime: String = sdf.format(Date())
                    viewModal.addLog(Log(logTitle, logDescription, currentDateAndTime))
                    Toast.makeText(this, "$logTitle Added", Toast.LENGTH_LONG).show()
                }
            }

            startActivity(Intent(applicationContext, TrainingActivity::class.java))
            this.finish()
        }
    }
}