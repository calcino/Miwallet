package com.calcino.miwallet.ui.homepage.fragment

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.calcino.miwallet.R
import com.calcino.miwallet.db.entity.ListItemCategory
import com.calcino.miwallet.ui.homepage.adapter.AdapterCategory
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetCategoryFragment : BottomSheetDialogFragment(), View.OnClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterCategory: AdapterCategory
    private lateinit var constraintLayout: ConstraintLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.category_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
        initRecyclerView()
        constraintLayout.setBackgroundColor(android.graphics.Color.TRANSPARENT)

    }

    private fun bind(view: View) {
        recyclerView = view.findViewById(R.id.recycler_view_category)
        constraintLayout = view.findViewById(R.id.bottom_sheet_category_layout)
    }

    private fun initRecyclerView() {
        val listItemCategory = ArrayList<ListItemCategory>()

        listItemCategory.add(0, ListItemCategory("Add New Category"))
        listItemCategory.add(1, ListItemCategory("Mobile", R.drawable.main_image))
        listItemCategory.add(2, ListItemCategory("Food", R.drawable.main_image))
        listItemCategory.add(3, ListItemCategory("Transportation", R.drawable.main_image))
        listItemCategory.add(4, ListItemCategory("Clothes", R.drawable.main_image))
        listItemCategory.add(5, ListItemCategory("Home", R.drawable.main_image))
        listItemCategory.add(6, ListItemCategory("Office", R.drawable.main_image))
        listItemCategory.add(7, ListItemCategory("Car", R.drawable.main_image))
        listItemCategory.add(8, ListItemCategory("Sport", R.drawable.main_image))

        val linearLayoutManager = LinearLayoutManager(activity)
        adapterCategory =
            AdapterCategory(listItemCategory)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapterCategory
    }

    override fun onClick(v: View?) {

    }

//    private fun showBottomSheetDialog() {
//        val view = layoutInflater.inflate(R.layout.category_bottom_sheet, null)
//        val dialog = context?.let { BottomSheetDialog(it) }
//        initRecyclerView()
//        dialog?.setContentView(view)
//        dialog?.show()
//
//    }


}
