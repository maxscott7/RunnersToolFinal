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

class TrainingActivity : AppCompatActivity(), NoteClickInterface, NoteClickDeleteInterface {

    lateinit var viewModol: NoteViewModal
    lateinit var notesRV: RecyclerView
    lateinit var addFAB: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_training)

        notesRV = findViewById(R.id.notesRV)
        addFAB = findViewById(R.id.idFAB)
        notesRV.layoutManager = LinearLayoutManager(this)

        val noteRVAdapter = NoteRVAdapter(this, this, this)

        notesRV.adapter = noteRVAdapter

        viewModol = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModal::class.java)

        viewModol.allNotes.observe(this, Observer { list ->
            list?.let {
                noteRVAdapter.updateList(it)
            }
        })
        addFAB.setOnClickListener {
            val intent = Intent(this@TrainingActivity, AddLogActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }

    override fun onNoteClick(log: Log) {
        val intent = Intent(this@TrainingActivity, AddLogActivity::class.java)
        intent.putExtra("noteType", "Edit")
        intent.putExtra("noteTitle", log.noteTitle)
        intent.putExtra("noteDescription", log.noteDescription)
        intent.putExtra("noteId", log.id)
        startActivity(intent)
        this.finish()
    }

    override fun onDeleteIconClick(log: Log) {
        viewModol.deleteNote(log)
        Toast.makeText(this, "${log.noteTitle} Deleted", Toast.LENGTH_LONG).show()
    }
}