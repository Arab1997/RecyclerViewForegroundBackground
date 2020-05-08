package com.example.baseactivity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.adapter.CustomAdapter
import com.example.myapplication.model.Member
import kotlinx.android.synthetic.main.activity_main.*
import my.mytoolbarscrolleffect.R


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

    }
    //refreshAdapter- har qanday malumotni yangilansa adapter refresh  qibergan
    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(members)
        recyclerView.adapter = adapter
    }


    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()

        for (i in 0..29) {
                members.add(Member("Makhmudov" + i, "Abdulloh" + i))

        }
        return members
    }

}
