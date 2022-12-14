package com.example.runnerstoolfinal

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TrainingActivity : AppCompatActivity(), logClickInterface, logClickDeleteInterface {

    lateinit var viewModol: logViewModal
    lateinit var logsRV: RecyclerView
    lateinit var addFAB: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_training)

        logsRV = findViewById(R.id.logsRV)
        addFAB = findViewById(R.id.idFAB)
        logsRV.layoutManager = LinearLayoutManager(this)

        val logRVAdapter = logRVAdapter(this, this, this)

        logsRV.adapter = logRVAdapter

        viewModol = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(logViewModal::class.java)

        viewModol.alllogs.observe(this, Observer { list ->
            list?.let {
                logRVAdapter.updateList(it)
            }
        })
        addFAB.setOnClickListener {
            val intent = Intent(this@TrainingActivity, AddLogActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }

    override fun onlogClick(log: Log) {
        val intent = Intent(this@TrainingActivity, AddLogActivity::class.java)
        intent.putExtra("logType", "Edit")
        intent.putExtra("logTitle", log.logTitle)
        intent.putExtra("logDescription", log.logDescription)
        intent.putExtra("logId", log.id)
        startActivity(intent)
        this.finish()
    }

    override fun onDeleteIconClick(log: Log) {
        viewModol.deletelog(log)
        Toast.makeText(this, "${log.logTitle} Deleted", Toast.LENGTH_LONG).show()
    }
}