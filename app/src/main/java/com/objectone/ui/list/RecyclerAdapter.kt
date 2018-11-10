package com.objectone.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.objectone.R
import com.objectone.core.list.data.ObjectOneItem

class RecyclerAdapter(private val fragment: Fragment) : ListAdapter<ObjectOneItem, ObjectOneViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ObjectOneItem>() {
            override fun areItemsTheSame(oldItem: ObjectOneItem, newItem: ObjectOneItem): Boolean {
                // TODO: implement
                return false
            }

            override fun areContentsTheSame(oldItem: ObjectOneItem, newItem: ObjectOneItem): Boolean {
                // TODO: implement
                return false
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectOneViewHolder {
        return ObjectOneViewHolder(
                fragment,
                LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.view_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ObjectOneViewHolder, position: Int) {
        val viewObject = getItem(position)
        holder.bind(viewObject)
    }
}