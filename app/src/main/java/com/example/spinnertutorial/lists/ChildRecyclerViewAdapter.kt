package com.example.spinnertutorial.lists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.R

class ChildRecyclerViewAdapter (private val childList: List<ChildItem>) :
RecyclerView.Adapter<ChildRecyclerViewAdapter.ChildViewHolder>(){

inner class ChildViewHolder (itemView : View) :RecyclerView.ViewHolder(itemView){
    val title :TextView = itemView.findViewById(R.id.childTitleTv)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
val view = LayoutInflater.from(parent.context).inflate(R.layout.child_item, parent, false)
        return ChildViewHolder(view)
    }

    override fun getItemCount(): Int {
return childList.size
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
holder.title.text = childList[position].title    }


}