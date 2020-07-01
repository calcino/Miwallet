package com.calcino.miwallet.ui.homepage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.calcino.miwallet.R
import com.calcino.miwallet.db.entity.ContentItemMain
import com.calcino.miwallet.db.entity.HeaderItemMain
import com.calcino.miwallet.db.entity.ListItemMain
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.text.SimpleDateFormat
import java.util.*

/**
 *
 */
class HomePageFragment : Fragment() {

    private lateinit var viewpager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterMain: AdapterMain
    private var list = listOf<String>()
    private val TAG = "HomePageFragment"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_page_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
        list = getMonths()
        viewpager.adapter = PagerMain(
            this,
            list as ArrayList<String>
        )
        TabLayoutMediator(tabLayout, viewpager) { tab, position ->
            tab.text = "${list[position]}"
        }.attach()
//        arguments?.takeIf {
//            it.containsKey(ARG_OBJECT)
//        }?.apply {
//            dateMonth.let {
//                it.text = getInt(ARG_OBJECT).toString()
//            }
//        }

        val linearLayoutManager = LinearLayoutManager(activity)
        adapterMain = AdapterMain(listItemMain)
        recyclerView!!.layoutManager = linearLayoutManager
        recyclerView!!.adapter = adapterMain

    }

    private val listItemMain: ArrayList<ListItemMain>
        private get() {
            val arrayList = ArrayList<ListItemMain>()
            for (j in 0..4) {
                val header = HeaderItemMain()
                header.date = "header$j"
                header.income = 500
                header.expense = -400
                arrayList.add(header)
                for (i in 0..3) {
                    val item = ContentItemMain()
                    item.title = i.toString() + ""
                    item.subtitle = "A$i"
                    arrayList.add(item)
                }
            }
            return arrayList
        }


    private fun bind(view: View) {
        viewpager = view.findViewById(R.id.view_pager)
        tabLayout = view.findViewById(R.id.tab_layout)
        recyclerView = view.findViewById(R.id.recycler_view_main)

    }

    private fun getMonths(): ArrayList<String> {
        val list = arrayListOf<String>()
        val calendar = Calendar.getInstance()
        for (index: Int in 0..4) {
            calendar.add(Calendar.MONTH, -index)
            val date: Date = calendar.time
            val format = SimpleDateFormat("MMMM")
            val dataOutput: String = format.format(date)
            Log.d(TAG, "getMonths: $dataOutput")
            list.add(index, dataOutput)
        }
        return list
        Log.d(TAG, "getMonths: $list")
    }


}

private const val ARG_OBJECT = "object"


class PartialFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_page_fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        arguments?.takeIf {
//            it.containsKey(ARG_OBJECT)
//        }?.apply {
//            textView.text = getInt(ARG_OBJECT).toString()
//        }
    }
}


