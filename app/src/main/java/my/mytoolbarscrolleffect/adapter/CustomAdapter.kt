package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Member


import my.mytoolbarscrolleffect.R

import java.text.ParsePosition
import java.util.*


//class CustomAdapter(val members: ArrayList<Member>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), ItemTouchHelperAdapter{ //Paging  add method val listener: OnBottomReachedListener
class CustomAdapter(val members: ArrayList<Member>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //Paging  add method val listener: OnBottomReachedListener

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
            holder.view_foreground.setText(member.firstname)
            holder.view_background.setText(member.lastName)
        }
    }
    class CustomViewHolder(iteView: View) : RecyclerView.ViewHolder(iteView) {
        var view_foreground = itemView.findViewById<TextView>(R.id.view_foreground)
        var view_background = itemView.findViewById<TextView>(R.id.view_background)
    }


    }






