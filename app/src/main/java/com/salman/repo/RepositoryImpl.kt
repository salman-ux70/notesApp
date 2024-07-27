package com.salman.repo

import com.salman.db.dao.NotesDao
import com.salman.notesapp.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dao: NotesDao
) : Repository {
    override suspend fun insert(note: Note) {
        withContext(Dispatchers.IO) {
            dao.insert(note)
        }
    }

    override suspend fun delete(note: Note) {
        withContext(Dispatchers.IO) {
            dao.delete(note)
        }
    }

    override suspend fun update(note: Note) {
        withContext(Dispatchers.IO) {
            dao.update(note)
        }
    }

    override suspend fun getAllNotes(): Flow<List<Note>> {
        return withContext(Dispatchers.IO) {
            dao.getAllNotes()
        }
    }
}