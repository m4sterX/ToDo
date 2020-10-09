package com.example.todo.data_base_sqlite

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todo.data.NoteCommonImpl

@Database(entities = [NoteCommonImpl::class], version = 4)
    abstract class NotesDataBase : RoomDatabase(){
    abstract fun noteDao() : NoteDAO
    companion object : SingletonHolder<NotesDataBase, Context>({
        Room.databaseBuilder(it.applicationContext, NotesDataBase::class.java, "Notes")
            .fallbackToDestructiveMigration()
            .build()
    })
}
