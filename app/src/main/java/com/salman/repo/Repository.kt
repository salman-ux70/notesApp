package com.salman.repo

import com.salman.notesapp.model.Note
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun insert(note: Note)

    suspend fun delete(note: Note)


    suspend fun update(note: Note)

    suspend fun getAllNotes() : Flow<List<Note>>
}