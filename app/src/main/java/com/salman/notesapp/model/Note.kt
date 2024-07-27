package com.salman.notesapp.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.UUID

const val tableName = "NotesEntity"

@RequiresApi(Build.VERSION_CODES.O)
@Entity(tableName = tableName)
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "entryDate")
    val entryDate: LocalDateTime = LocalDateTime.now()
)
