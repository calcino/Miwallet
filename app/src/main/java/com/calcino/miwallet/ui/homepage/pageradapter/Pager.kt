package com.calcino.miwallet.ui.homepage.pageradapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class Pager : PagerAdapter {
    lateinit var views: MutableList<View>
    lateinit var context: Context

    constructor(views: MutableList<View>, context: Context) : super() {
        this.views = views
        this.context = context
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return views.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(views[position])
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view: View = views[position]
        container.addView(view)
        return view
    }

    override fun getItemPosition(`object`: Any): Int {
        for (index: Int in 0..count) {
            if (`object` == views[index]) {
                return index
            }
        }
        return POSITION_NONE
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "View " + (position + 1)
    }
}