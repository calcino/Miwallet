package com.calcino.miwallet.ui.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.calcino.miwallet.R
import com.calcino.miwallet.ui.homepage.pageradapter.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

/**
 *
 */
class HomePageFragment : Fragment() {

    private lateinit var viewpager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var pagerAdapter: PagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userList = arrayListOf("John", "Doe", "Foo", "Bar")


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_page_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewpager = view.findViewById(R.id.view_pager)
        tabLayout = view.findViewById(R.id.tab_layout)
        viewpager.adapter = PagerAdapter(this)
        TabLayoutMediator(tabLayout, viewpager) { tab, position ->
            tab.text = "OBJECT ${(position + 1)}"
        }.attach()
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
        arguments?.takeIf {
            it.containsKey(ARG_OBJECT)
        }?.apply {
            val textView: TextView = view.findViewById(R.id.text1)
            textView.text = getInt(ARG_OBJECT).toString()
        }
    }
}


