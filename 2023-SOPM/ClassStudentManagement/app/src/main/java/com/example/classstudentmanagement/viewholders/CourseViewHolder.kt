package com.example.classstudentmanagement.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.classstudentmanagement.R

class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val courseName: TextView = itemView.findViewById(R.id.course_name)
    val courseDescription: TextView = itemView.findViewById(R.id.course_description)
}