package com.salman.notesapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salman.notesapp.data.NotesDataSource
import com.salman.notesapp.model.Note
import com.salman.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _notesDetailsList = MutableStateFlow(emptyList<Note>())

    val notesDetailsList = _notesDetailsList.asStateFlow()

    fun getStudentDetails() {
        viewModelScope.launch(IO) {
            repository.getAllNotes().collectLatest {
                _notesDetailsList.tryEmit(it)
            }
        }
    }

    fun updateStudent(note: Note) {
        viewModelScope.launch(IO) {
            repository.update(note)
        }
    }

    fun insertNote(note: Note) {
        viewModelScope.launch(IO) {
            repository.insert(note)
        }
    }

    fun removeNote(note: Note) {
        viewModelScope.launch(IO) {
            repository.delete(note)
        }
    }

    var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NotesDataSource.loadNotes())
    }



    fun getAllNotes(): List<Note> = noteList
}