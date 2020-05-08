package com.example.baseactivity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.*
import com.example.myapplication.adapter.CustomAdapter
import com.example.myapplication.model.Member
import kotlinx.android.synthetic.main.activity_main.*
import my.mytoolbarscrolleffect.R
import my.mytoolbarscrolleffect.helper.RecyclerItemTouchHelper
import java.sql.Driver

/*import my.mytoolbarscrolleffect.helper.ItemTouchHelperAdapter
import my.mytoolbarscrolleffect.helper.SimpleItemTouchHelperCallback*/


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
       /* val animation = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_fall_down)
        val animation1 = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_from_bottom)
        val animatio2 = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_from_right)
        recyclerView.layoutAnimation = animation*/

    }



    //refreshAdapter- har qanday malumotni yangilansa adapter refresh  qibergan
    private fun refreshAdapter(members: ArrayList<Member>) {
        val adapter = CustomAdapter(members)
        recyclerView.adapter = adapter

//-------------------------------Drag and Swipe ---------------------------------------//

     /*   val callback = SimpleItemTouchHelperCallback(adapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(recyclerView)*/

    }


    private fun prepareMemberList(): ArrayList<Member> {
        val members = ArrayList<Member>()

        for (i in 0..29) {
                members.add(Member("Makhmudov" + i, "Abdulloh" + i))

        }
        return members
    }

}


