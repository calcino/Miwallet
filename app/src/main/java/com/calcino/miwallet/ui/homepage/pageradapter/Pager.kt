package com.calcino.miwallet.ui.homepage.pageradapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.calcino.miwallet.ui.homepage.PartialFragment


class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val ARG_OBJECT = "object"


    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = PartialFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position + 1)
        }
        return fragment
    }


}


