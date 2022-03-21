package com.example.travelwishlistandroid

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

interface OnDataChangedListener {
    fun onListItemMoved(from: Int, to: Int)
    fun onListItemDeleted(position: Int)
}

class OnListItemSwipeListener(private val onDataChangedListener: OnDataChangedListener): ItemTouchHelper.SimpleCallback(
    ItemTouchHelper.UP or ItemTouchHelper.DOWN,
    ItemTouchHelper.RIGHT
) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        val fromPosition = viewHolder.adapterPosition
        val toPosition = target.adapterPosition
        onDataChangedListener.onListItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if (direction == ItemTouchHelper.RIGHT) {
            onDataChangedListener.onListItemDeleted(viewHolder.adapterPosition)
        }
    }
}