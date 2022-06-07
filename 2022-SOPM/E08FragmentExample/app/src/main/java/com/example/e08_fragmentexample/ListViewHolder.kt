package com.example.e08_fragmentexample

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val studentName = itemView.findViewById<TextView>(R.id.student_name)
}