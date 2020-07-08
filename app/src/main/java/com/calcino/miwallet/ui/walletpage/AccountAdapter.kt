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


class AccountAdapter(
    groups: List<ExpandableGroup<*>?>,
    private val context: Context,
    var onItemClickListener: ChildAccountViewHolder.OnItemClickListener
) :
    ExpandableRecyclerViewAdapter<AccountViewHolder, ChildAccountViewHolder>(groups) {

    override fun onCreateGroupViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.account_list_item, parent, false)
        return AccountViewHolder(view)
    }

    override fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): ChildAccountViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.child_account_list_item, parent, false)
        return ChildAccountViewHolder(view, onItemClickListener)
    }

    override fun onBindChildViewHolder(
        holder: ChildAccountViewHolder, flatPosition: Int, group: ExpandableGroup<*>,
        childIndex: Int
    ) {
        val accountChild = group.items[childIndex] as AccountChild
        holder.moneyTransfer.text = accountChild.monyTransfer
        holder.transactions.text = accountChild.transaction
        holder.edit.text = accountChild.edit

        holder.moneyTransfer.setOnClickListener {
            onItemClickListener.onMoneyTransferClick(position = flatPosition, itemView = it)
        }
        holder.transactions.setOnClickListener {
            onItemClickListener.onTransactionClick(position = flatPosition, itemView = it)
        }
        holder.edit.setOnClickListener {
            onItemClickListener.onEditClick(position = flatPosition, itemView = it)
        }
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

class ChildAccountViewHolder(itemView: View, var onItemClickListener: OnItemClickListener) :
    ChildViewHolder(itemView), View.OnClickListener {
    val moneyTransfer: TextView
    val edit: TextView
    val transactions: TextView

    init {
        moneyTransfer = itemView.findViewById(R.id.text_view_money_transfer)
        transactions = itemView.findViewById(R.id.text_view_transaction)
        edit = itemView.findViewById(R.id.text_view_edit)
        itemView.setOnClickListener(this)
    }

    interface OnItemClickListener {
        fun onMoneyTransferClick(position: Int, itemView: View) {}
        fun onTransactionClick(position: Int, itemView: View) {}
        fun onEditClick(position: Int, itemView: View) {}
    }


    override fun onClick(v: View?) {
        onItemClickListener.onMoneyTransferClick(absoluteAdapterPosition, itemView)
        onItemClickListener.onTransactionClick(absoluteAdapterPosition, itemView)
        onItemClickListener.onEditClick(absoluteAdapterPosition, itemView)
    }
}