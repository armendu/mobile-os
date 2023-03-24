package com.example.e0601roomproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e0601roomproject.R

class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val studentItemView: TextView = itemView.findViewById(R.id.textView)

    fun bind(text: String?) {
        studentItemView.text = text
    }

    companion object {
        fun create(parent: ViewGroup): StudentViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
            return StudentViewHolder(view)
        }
    }
}