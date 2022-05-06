package com.example.recyclerviewexercise.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexercise.R
import com.example.recyclerviewexercise.viewmodels.StudentViewModel

class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindData(studentViewModel: StudentViewModel) {
        val nameTextView = itemView.findViewById<TextView>(R.id.name_text)
        val surnameTextView = itemView.findViewById<TextView>(R.id.surname_text)

        nameTextView.text = studentViewModel.name
        surnameTextView.text = studentViewModel.surname
    }
}