package com.calcino.miwallet.ui.homepage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.calcino.miwallet.R
import com.calcino.miwallet.db.entity.ContentItemMain
import com.calcino.miwallet.db.entity.HeaderItemMain
import com.calcino.miwallet.db.entity.ListItemMain


class AdapterMain(
    val list: MutableList<ListItemMain>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == TYPE_HEADER) {
            val v = inflater.inflate(R.layout.header_item_main, parent, false)
            VHHeader(v)
        } else {
            val v = inflater.inflate(R.layout.content_item_main, parent, false)
            VHItem(v)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is VHHeader) {
            // VHHeader VHheader = (VHHeader)holder;
            val currentItem = list[position] as HeaderItemMain
            holder.date.text = currentItem.date
            holder.expense.text = currentItem.expense.toString()
            holder.income.text = currentItem.income.toString()
        } else if (holder is VHItem) {
            val currentItem = list[position] as ContentItemMain
            holder.txtTitle.text = currentItem.title
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (isPositionHeader(position)) TYPE_HEADER else TYPE_ITEM
    }

    private fun isPositionHeader(position: Int): Boolean {
        return list[position] is HeaderItemMain
    }

    override fun getItemCount(): Int {
        return list.size
    }

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEM = 1
    }

}

internal class VHHeader(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var date: TextView
    var income: TextView
    var expense: TextView

    init {
        date = itemView.findViewById<View>(R.id.text_header_date) as TextView
        income = itemView.findViewById<View>(R.id.text_header_income) as TextView
        expense = itemView.findViewById<View>(R.id.text_header_expense) as TextView
    }
}

internal class VHItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txtTitle: TextView
    var txtSubTitle: TextView
    var date: TextView
    var cost: TextView

    init {
        txtTitle = itemView.findViewById<View>(R.id.text_list_title) as TextView
        txtSubTitle = itemView.findViewById<View>(R.id.text_list_subtitle) as TextView
        date = itemView.findViewById<View>(R.id.text_list_date) as TextView
        cost = itemView.findViewById<View>(R.id.text_list_cost) as TextView
    }

}