package com.example.classstudentmanagement.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.classstudentmanagement.R
import com.example.classstudentmanagement.models.Course
import com.example.classstudentmanagement.viewholders.CourseViewHolder

class CoursesAdapter(private val courses: List<Course>) : RecyclerView.Adapter<CourseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.course_item, parent, false)
        return CourseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return courses.count()
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]
        holder.courseName.text = course.name
        holder.courseDescription.text = course.description
    }
}
