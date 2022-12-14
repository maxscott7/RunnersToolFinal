package com.example.runnerstoolfinal

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModal (application: Application) :AndroidViewModel(application) {

    val allNotes : LiveData<List<Log>>
    val repository : LogRepository

    init {
        val dao = LogDatabase.getDatabase(application).getNotesDao()
        repository = LogRepository(dao)
        allNotes = repository.allNotes
    }

    fun deleteNote (log: Log) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(log)
    }

    fun updateNote(log: Log) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(log)
    }

    fun addLog(log: Log) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(log)
    }
}