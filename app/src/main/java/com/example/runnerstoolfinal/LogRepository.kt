package com.example.runnerstoolfinal

import androidx.lifecycle.LiveData

class LogRepository(private val trainingLogDao: TrainingLogDao) {

    // on below line we are creating a variable for our list
    // and we are getting all the logs from our DAO class.
    val alllogs: LiveData<List<Log>> = trainingLogDao.getAlllogs()

    // on below line we are creating an insert method
    // for adding the log to our database.
    suspend fun insert(log: Log) {
        trainingLogDao.insert(log)
    }

    // on below line we are creating a delete method
    // for deleting our log from database.
    suspend fun delete(log: Log){
        trainingLogDao.delete(log)
    }

    // on below line we are creating a update method for
    // updating our log from database.
    suspend fun update(log: Log){
        trainingLogDao.update(log)
    }
}