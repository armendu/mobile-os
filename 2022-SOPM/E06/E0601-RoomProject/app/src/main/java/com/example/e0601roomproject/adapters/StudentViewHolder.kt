package com.example.e0601roomproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e0601roomproject.R

class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameTextView = itemView.findViewById<TextView>(R.id.text_view)

    fun bind(textToSet: String?) {
        nameTextView.text = textToSet
    }

    companion object {
        fun create(parent: ViewGroup) : StudentViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
            return StudentViewHolder(view)
        }
    }
}