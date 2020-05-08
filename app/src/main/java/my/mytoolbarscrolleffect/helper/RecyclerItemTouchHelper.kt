package my.mytoolbarscrolleffect.helper

import android.graphics.Canvas
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.CustomAdapter
import java.io.NotActiveException
import java.text.FieldPosition
import java.util.*

open class RecyclerItemTouchHelper(dragsDirs: Int, swipeDirs: Int, private val  listener: RecyclerItemTouchHelperListener): ItemTouchHelper.SimpleCallback(dragsDirs, swipeDirs) {


    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        return true
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int)  {
        if (viewHolder != null){
            val foregroundView = (viewHolder as CustomAdapter.CustomViewHolder).view_foreground

                ItemTouchHelper.Callback.getDefaultUIUtil().onSelected(foregroundView)
            }
        }

        override fun onChildDrawOver(c: Canvas,recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX:Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean){
            val  foregroundView = (viewHolder as CustomAdapter.CustomViewHolder).view_background
            ItemTouchHelper.Callback.getDefaultUIUtil().onDrawOver(c, recyclerView, foregroundView, dX /3, dY, actionState, isCurrentlyActive)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        listener.onSwiped(viewHolder, direction, viewHolder.adapterPosition)
    }

    override fun convertToAbsoluteDirection(flags: Int, layoutDirection: Int): Int {
        return super.convertToAbsoluteDirection(flags, layoutDirection)
    }

    interface RecyclerItemTouchHelperListener{
        fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int)
    }


}