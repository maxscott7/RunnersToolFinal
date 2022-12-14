package com.example.runnerstoolfinal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "logsTable")


class Log (@ColumnInfo(name = "title")val logTitle :String, @ColumnInfo(name = "description")val logDescription :String, @ColumnInfo(name = "timestamp")val timeStamp :String) {
    @PrimaryKey(autoGenerate = true) var id = 0
}