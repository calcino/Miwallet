package com.calcino.miwallet.ui.homepage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.calcino.miwallet.R
import com.calcino.miwallet.db.entity.ListItemCategory

class AdapterCategory(val list: MutableList<ListItemCategory>) :
    RecyclerView.Adapter<CategoryItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemHolder {
        val inflater = LayoutInflater.from(parent.context)

        return if (viewType == 1) {
            val v = inflater.inflate(R.layout.category_list_header, parent, false)
            return CategoryItemHolder(v)
        } else {
            val v = inflater.inflate(R.layout.category_list_item, parent, false)
            CategoryItemHolder(v)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CategoryItemHolder, position: Int) {
        val currentItem = list[position]
        if (position == 1) {
            holder.text_title?.text = currentItem.title
        } else {
            holder.text_title?.text = currentItem.title
            currentItem.image?.let { holder.imageView?.setBackgroundResource(it) }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            1
        } else {
            2
        }
    }
}

class CategoryItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var text_title: TextView? = null
    var imageView: ImageView? = null

    init {
        text_title = itemView.findViewById<View>(R.id.text_view_category_item) as TextView
        imageView = itemView.findViewById<View>(R.id.image_view_category_item) as ImageView
    }


}
