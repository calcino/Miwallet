package com.calcino.miwallet.ui.homepage

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class PagerMain(fragment: Fragment, var list: ArrayList<String>) : FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = PartialFragment()
//        fragment.arguments = Bundle().apply {
//            putInt(list[position], position + 1)
//        }
        return fragment
    }

}


