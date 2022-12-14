package com.example.runnerstoolfinal

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TrainingLogDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(log :Log)


    @Delete
    fun delete(log: Log)


    @Query("Select * from notesTable order by id ASC")
    fun getAllNotes(): LiveData<List<Log>>

    @Update
    fun update(log: Log)

}