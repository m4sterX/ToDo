package com.example.todo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.todo.R
import com.example.todo.activity.MainActivity
import com.example.todo.data.NoteCommonImpl
import com.example.todo.view_model.MainListViewModel
import kotlinx.android.synthetic.main.fragment_second_add_note.*


class SecondFragmentAddNote : Fragment() {

    override fun onStart() {
        super.onStart()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second_add_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_back.setOnClickListener { (activity as MainActivity).navCont.navigate(R.id.action_secondFragmentAddNote_to_fragmentMainList) }

        val mViewModel = ViewModelProvider(this).get(MainListViewModel::class.java)
        ImageButton_AddNote.setOnClickListener {
            val text = EditText_EnterText.text.toString()
            mViewModel.addNote(NoteCommonImpl(text))
            (activity as MainActivity).navCont.navigate((R.id.action_secondFragmentAddNote_to_fragmentMainList))
        }




    }

}

