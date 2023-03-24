package com.example.recyclerviewexercise.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexercise.R
import com.example.recyclerviewexercise.holders.StudentViewHolder
import com.example.recyclerviewexercise.viewmodels.StudentViewModel

class StudentsAdapter : RecyclerView.Adapter<StudentViewHolder>() {
    private var students = ArrayList<StudentViewModel>()

    fun setData(studentList: ArrayList<StudentViewModel>){
        students = studentList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_item, parent, false)

        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bindData(students[position])
    }

    override fun getItemCount(): Int {
        return students.size
    }
}