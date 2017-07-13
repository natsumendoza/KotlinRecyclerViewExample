package com.example.rr.kotlinrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.find

class CustomAdapter(val userList: ArrayList<User>, val listener: (User) -> Unit) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(userList[position], listener)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName = itemView.find<TextView>(R.id.textViewName)
        val textViewAddress = itemView.find<TextView>(R.id.textViewAddress)

        fun bind(user: User, listener: (User) -> Unit) = with(itemView) {
            textViewName.text = user.name
            textViewAddress.text = user.address
            setOnClickListener { listener(user) }
        }
    }
}