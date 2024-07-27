package com.salman.notesapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.salman.notesapp.data.NotesDataSource
import com.salman.notesapp.screens.NotesScreen
import com.salman.notesapp.ui.theme.NotesAppTheme
import com.salman.notesapp.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesAppTheme {
                Surface {
                   val noteViewModel : NoteViewModel by viewModels()
                    NoteApp(noteViewModel)
                }
            }
        }
    }
}

@Composable
fun NoteApp(noteViewModel: NoteViewModel = viewModel()) {
    noteViewModel. getStudentDetails()
    val notes by noteViewModel.notesDetailsList.collectAsState()

    NotesScreen(notes, {
        noteViewModel.insertNote(it)
    }, {
        noteViewModel.removeNote(it)
    })

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NotesAppTheme {
        NotesScreen(NotesDataSource.loadNotes(), {}, {

        })
    }
}