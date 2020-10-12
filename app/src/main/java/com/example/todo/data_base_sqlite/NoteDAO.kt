package com.example.todo.data_base_sqlite

import androidx.room.*
import com.example.todo.data.NoteCommonImpl

@Dao
interface NoteDAO {
    @Query("SELECT * FROM Notes")
    fun getAllNotes() : List<NoteCommonImpl>

    @Query("SELECT * FROM Notes WHERE id IN(:noteIds)")
    fun getAllByIds(noteIds: List<Int>) : List<NoteCommonImpl>

    @Query("SELECT * FROM Notes WHERE id =:id")
    fun getNoteById(id: Int) : NoteCommonImpl

    @Query("SELECT * FROM Notes WHERE text LIKE (:text)")
    fun getNoteByText(text: String) : NoteCommonImpl

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteCommonImpl: NoteCommonImpl)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg noteCommonImpls: NoteCommonImpl)

    @Delete
    fun deleteNote(vararg noteCommonImpls: NoteCommonImpl)

    @Delete
    fun deleteNote(noteCommonImpls: List<NoteCommonImpl>)
}