package com.example.runnerstoolfinal

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class logViewModal (application: Application) :AndroidViewModel(application) {

    val alllogs : LiveData<List<Log>>
    val repository : LogRepository

    init {
        val dao = LogDatabase.getDatabase(application).getlogsDao()
        repository = LogRepository(dao)
        alllogs = repository.alllogs
    }

    fun deletelog (log: Log) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(log)
    }

    fun updatelog(log: Log) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(log)
    }

    fun addLog(log: Log) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(log)
    }
}