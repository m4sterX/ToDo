package com.example.todo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RestrictTo
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.activity.MainActivity
import com.example.todo.adapter.NotesListAdapter
import com.example.todo.data.NoteCommonImpl
import com.example.todo.view_model.MainListViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_main_list.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class FragmentMainList : Fragment() {

    lateinit var mainListViewModel: MainListViewModel
    var noteCommonImpls:List<NoteCommonImpl>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainListViewModel = ViewModelProvider(this).get(MainListViewModel::class.java) //init viewModel
        runBlocking (Dispatchers.IO){ getNotesList() } // test cor
        return inflater.inflate(R.layout.fragment_main_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainListViewModel.getLiveDataNotesList().observe(viewLifecycleOwner, Observer {
            noteCommonImpls = it
            changeAdapter(it)
        })

        val btnAddNote: FloatingActionButton = view.findViewById(R.id.Floating_btn)
        val itemDecor = DividerItemDecoration(context,DividerItemDecoration.VERTICAL)
        val recyclerList: RecyclerView = Recycler_notesList

        val ex: ExecutorService = Executors.newSingleThreadExecutor()

        recyclerList.layoutManager = LinearLayoutManager(view.context)
        recyclerList.addItemDecoration(itemDecor)

        btnAddNote.setOnClickListener {
            (activity as MainActivity).navCont.navigate(R.id.action_fragmentMainList_to_secondFragmentAddNote)
        }
    }

    suspend  fun getNotesList() {
        mainListViewModel.fetchList() //send the request to a db from VM
    }
    fun changeAdapter(vNoteCommonImpls: List<NoteCommonImpl>){
        val adaptee = NotesListAdapter(vNoteCommonImpls)
        Recycler_notesList.adapter = adaptee
        adaptee.notifyDataSetChanged()
    }
}


