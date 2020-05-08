package com.example.baseactivity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.*
import com.example.myapplication.adapter.CustomAdapter
import com.example.myapplication.model.Member
import kotlinx.android.synthetic.main.activity_main.*
import my.mytoolbarscrolleffect.R
import my.mytoolbarscrolleffect.helper.RecyclerItemTouchHelper

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView();
        val members = prepareMemberList()
        refreshAdapter(members)
    }

    private fun initView() {
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val itemTouchHelperCallback = RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, object : RecyclerItemTouchHelper.RecyclerItemTouchHelperListener{
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {
            Log.d("test", "position" + position)
        }
    })
        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView)
    }

    private fun refreshAdapter(members: ArrayList<Member>) {
        val adapter = CustomAdapter(members)
        recyclerView.adapter = adapter
    }
    private fun prepareMemberList(): ArrayList<Member> {
        val members = ArrayList<Member>()

        for (i in 0..29) {
                members.add(Member("Makhmudov" + i, "Abdulloh" + i))

        }
        return members
    }

}


