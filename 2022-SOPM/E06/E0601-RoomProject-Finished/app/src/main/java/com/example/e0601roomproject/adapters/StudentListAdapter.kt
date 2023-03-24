package com.example.e0601roomproject.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.e0601roomproject.data.Student

class StudentListAdapter : ListAdapter<Student, StudentViewHolder>(CallbackUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.name)
    }

    class CallbackUtil : DiffUtil.ItemCallback<Student>(){
        override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem == newItem
        }
    }
}