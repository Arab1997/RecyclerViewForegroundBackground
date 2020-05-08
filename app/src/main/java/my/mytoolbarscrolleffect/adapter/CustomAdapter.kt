package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Member


import my.mytoolbarscrolleffect.R

import my.mytoolbarscrolleffect.helper.RecyclerItemTouchHelper
import java.text.FieldPosition
import java.text.ParsePosition
import java.util.*


//class CustomAdapter(val members: ArrayList<Member>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), ItemTouchHelperAdapter{ //Paging  add method val listener: OnBottomReachedListener
class CustomAdapter(val members: ArrayList<Member>, dragsDirs: Int, swipeDirs: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
    /*override fun onItemDismiss(position: Int){
        members.removeAt(position)   // usha positiondagi itemni membersdan optashash
        notifyDataSetChanged()   // boshqattan yangilash
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int){   // qaysidir postiondan qaysidir postionga oborib qoyish itemni
        if (fromPosition < toPosition){
            for (i in fromPosition until  toPosition){
                Collections.swap(members, i, i + 1)
            }
        }else{
            for (i in fromPosition downTo  toPosition + 1){
                Collections.swap(members, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }*/
    }






