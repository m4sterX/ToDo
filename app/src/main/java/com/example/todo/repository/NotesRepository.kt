package com.example.todo.repository

import com.example.todo.data.NoteCommonImpl

interface NotesRepository {
    fun loadNotesList() : List<NoteCommonImpl>
    fun addNewNote(noteCommonImpl: NoteCommonImpl)
    fun deleteNote(noteCommonImpl: NoteCommonImpl)
}