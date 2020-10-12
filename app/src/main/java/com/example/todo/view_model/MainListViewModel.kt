package com.example.todo.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.todo.repository.NotesRepository
import com.example.todo.data.NoteCommonImpl
import com.example.todo.repository.NotesRepositoryImpl

class MainListViewModel(application: Application) : AndroidViewModel(application) {

    private val notesListLivedata = MutableLiveData<List<NoteCommonImpl>>()
    val repositoryImpl : NotesRepository = NotesRepositoryImpl(getApplication())

    fun addNote(noteCommonImpl: NoteCommonImpl){
        repositoryImpl.addNewNote(noteCommonImpl)
    }

    fun getLiveDataNotesList(): LiveData<List<NoteCommonImpl>>{
        return notesListLivedata
    }
    fun fetchList(){
        notesListLivedata.postValue(repositoryImpl.loadNotesList())
    }
    fun setStrikeThrowText(){

    }
}