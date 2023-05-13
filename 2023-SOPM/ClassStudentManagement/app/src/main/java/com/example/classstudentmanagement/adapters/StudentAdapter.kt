package com.example.classstudentmanagement.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.classstudentmanagement.R
import com.example.classstudentmanagement.models.Student

class StudentAdapter : ListAdapter<Student, StudentAdapter.StudentViewHolder>(Comperer) {

    class StudentViewHolder(itemView: View) : ViewHolder(itemView) {
        val studentName: TextView = itemView.findViewById(R.id.student_name)
        val studentId: TextView = itemView.findViewById(R.id.student_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_item, parent, false)

        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = getItem(position)
        holder.studentName.text = "${student.name} ${student.surname}"
        holder.studentId.text = student.id.toString()
    }

    companion object {
        private val Comperer = object : DiffUtil.ItemCallback<Student>() {
            override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}