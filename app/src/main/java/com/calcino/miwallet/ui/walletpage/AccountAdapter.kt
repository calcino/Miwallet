package com.calcino.miwallet.ui.walletpage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.calcino.miwallet.R
import com.calcino.miwallet.db.entity.AccountChild
import com.calcino.miwallet.utils.expandableRecyclerview.ExpandableRecyclerViewAdapter
import com.calcino.miwallet.utils.expandableRecyclerview.models.ExpandableGroup
import com.calcino.miwallet.utils.expandableRecyclerview.viewholders.ChildViewHolder
import com.calcino.miwallet.utils.expandableRecyclerview.viewholders.GroupViewHolder


class AccountAdapter(groups: List<ExpandableGroup<*>?>, private val context: Context) :
    ExpandableRecyclerViewAdapter<AccountViewHolder, ChildAccountViewHolder>(groups) {
    override fun onCreateGroupViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.account_list_item, parent, false)
        return AccountViewHolder(view)
    }

    override fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): ChildAccountViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.child_account_list_item, parent, false)
        return ChildAccountViewHolder(view)
    }

    override fun onBindChildViewHolder(
        holder: ChildAccountViewHolder, flatPosition: Int, group: ExpandableGroup<*>,
        childIndex: Int
    ) {
        val accountChild = group.items[childIndex] as AccountChild
        holder.moneyTransfer.text = accountChild.monyTransfer
//        holder.transactions.text = accountChild.transaction
//        holder.edit.text = accountChild.edit
    }

    override fun onBindGroupViewHolder(
        holder: AccountViewHolder, flatPosition: Int,
        group: ExpandableGroup<*>
    ) {
        holder.setAccountTitle(group)
    }

}

class AccountViewHolder(itemView: View) : GroupViewHolder(itemView) {
    private val accountName: TextView
    private val balance: TextView
    private val arrowUpward: ImageView
    private val arrowDownward: ImageView
    fun setAccountTitle(group: ExpandableGroup<*>) {
        accountName.text = group.title
        balance.text = group.balance.toString()
    }

    override fun expand() {
        animateExpand()
    }

    private fun animateExpand() {
        arrowDownward.visibility = View.GONE
        arrowUpward.visibility = View.VISIBLE
    }

    override fun collapse() {
        arrowDownward.visibility = View.VISIBLE
        arrowUpward.visibility = View.GONE
    }

    init {
        accountName = itemView.findViewById(R.id.text_view_account_name)
        balance = itemView.findViewById(R.id.text_view_account_balance)
        arrowUpward = itemView.findViewById(R.id.upward_arrow)
        arrowDownward = itemView.findViewById(R.id.downward_arrow)
    }
}

class ChildAccountViewHolder(itemView: View) : ChildViewHolder(itemView) {
    val moneyTransfer: TextView
    val edit: TextView
    val transactions: TextView

    init {
        moneyTransfer = itemView.findViewById(R.id.text_view_money_transfer)
        transactions = itemView.findViewById(R.id.text_view_transaction)
        edit = itemView.findViewById(R.id.text_view_edit)
    }
}