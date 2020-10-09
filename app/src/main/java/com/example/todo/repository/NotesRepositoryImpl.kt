package com.example.todo.repository

import android.content.Context
import com.example.todo.data.NoteCommonImpl
import com.example.todo.data_base_sqlite.NotesDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors

class NotesRepositoryImpl(val context: Context) :
    NotesRepository {

    private val coreNumber = Runtime.getRuntime().availableProcessors()
    val executor = Executors.newFixedThreadPool(coreNumber)

    override fun loadNotesList(): List<NoteCommonImpl> {
        return runBlocking(Dispatchers.IO) {
            getListSuspending()
        }
    }

    override fun addNewNote(noteCommonImpl: NoteCommonImpl) {
        executor.execute {
            NotesDataBase.getInstance(context).noteDao().insertNote(noteCommonImpl)
        }
    }

    override fun deleteNote(noteCommonImpl: NoteCommonImpl) {
        executor.execute {
            NotesDataBase.getInstance(context).noteDao().deleteNote(noteCommonImpl)
        }
    }

    private suspend fun getListSuspending(): List<NoteCommonImpl> {
        return NotesDataBase.getInstance(context).noteDao().getAllNotes()
    }
}
