package com.example.e08_fragmentexample.packages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e08_fragmentexample.ListViewHolder
import com.example.e08_fragmentexample.R

class RecyclerAdapter : RecyclerView.Adapter<ListViewHolder>() {
    var listOfStudents = ArrayList<String>()

    fun setList(students: List<String>) {
        listOfStudents.clear()
        listOfStudents.addAll(students)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_item, parent, false)

        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.studentName.text = listOfStudents[position]
    }

    override fun getItemCount(): Int {
        return listOfStudents.size
    }
}