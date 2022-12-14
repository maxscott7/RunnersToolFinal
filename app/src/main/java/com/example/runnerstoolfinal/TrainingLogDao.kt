package com.example.runnerstoolfinal

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TrainingLogDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(log :Log)


    @Delete
    fun delete(log: Log)


    @Query("Select * from logsTable order by id ASC")
    fun getAlllogs(): LiveData<List<Log>>

    @Update
    fun update(log: Log)

}