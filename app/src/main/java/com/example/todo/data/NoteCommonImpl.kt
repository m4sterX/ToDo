package com.example.todo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
 data class NoteCommonImpl (
    @ColumnInfo override var text: String = "добавить описание",
    @ColumnInfo override var isImportant: Boolean = false) : Note
{
    @PrimaryKey(autoGenerate = true) override var id: Int = 0
}