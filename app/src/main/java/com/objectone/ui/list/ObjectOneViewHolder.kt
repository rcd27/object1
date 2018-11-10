package com.objectone.ui.list

import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.objectone.core.list.data.ObjectOneItem
import kotlinx.android.synthetic.main.view_list_item.view.*

class ObjectOneViewHolder(private val fragment: Fragment, itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(viewObject: ObjectOneItem) {
        itemView.contentDescription = viewObject.id // for testing purpose
        itemView.item_list_id.text = viewObject.id
        /* WARNING */
        Glide.with(fragment)
                .load(viewObject.image)
                .apply(RequestOptions.centerCropTransform())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(itemView.item_list_avatar)
        /* END OF WARNING */
        itemView.item_list_title.text = viewObject.title
    }
}
