package com.example.classstudentmanagement.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.classstudentmanagement.R
import com.example.classstudentmanagement.models.Post

class PostsAdapter : ListAdapter<Post, PostsAdapter.StudentViewHolder>(Comperer) {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postTitle: TextView = itemView.findViewById(R.id.student_name)
        val postSubtitle: TextView = itemView.findViewById(R.id.student_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_item, parent, false)

        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = getItem(position)
        holder.postTitle.text = "${student.postTitle}"
        holder.postSubtitle.text = student.postSubtitle.toString()
    }

    companion object {
        private val Comperer = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                //return oldItem == newItem
                return true
            }

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                //return oldItem.id == newItem.id
                return true
            }
        }
    }
}