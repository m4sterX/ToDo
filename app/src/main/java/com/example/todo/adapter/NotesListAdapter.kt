package com.example.todo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.data.NoteCommonImpl
import com.example.todo.R

class NotesListAdapter() : RecyclerView.Adapter<NotesListAdapter.ViewHolder>() {
    constructor(notesList: List<NoteCommonImpl>) : this() {
        mNotesList = notesList
    }

    var mNotesList: List<NoteCommonImpl> = ArrayList(0)


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemText: TextView = itemView.findViewById(R.id.main_text)

        init {
            itemView.setOnClickListener { v: View ->
                val position = adapterPosition
            }
        }
    }

    override fun getItemCount(): Int = mNotesList.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemText.text = mNotesList[position].text
    }
}