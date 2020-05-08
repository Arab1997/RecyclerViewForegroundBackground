package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Member


import my.mytoolbarscrolleffect.R


class CustomAdapter(val members: List<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() { //Paging  add method val listener: OnBottomReachedListener

    override fun getItemCount(): Int {
        return members.size
    }
    // -------------------- Hohlagan turdagi listni hosil qiladi-------------------------//
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val member = members.get(position)

        if (holder is CustomViewHolder) {
            holder.first_name.setText(member.firstname)
            holder.last_name.setText(member.lastName)
        }

    }


    class CustomViewHolder(iteView: View) : RecyclerView.ViewHolder(iteView) {
        var first_name = itemView.findViewById<TextView>(R.id.first_name)
        var last_name = itemView.findViewById<TextView>(R.id.last_name)


    }


}






