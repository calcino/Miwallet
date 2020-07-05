package com.calcino.miwallet.ui.homepage.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.calcino.miwallet.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


/**
 */
class IncomeFragment : Fragment(), View.OnClickListener {

    private lateinit var textViewCategoryIncome: TextView
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private lateinit var bottomSheetLayout: ConstraintLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_income, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
        initBottomSheet()
        textViewCategoryIncome.setOnClickListener(this)

    }

    private fun initBottomSheet() {
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        bottomSheetBehavior.state = (BottomSheetBehavior.STATE_EXPANDED)
        bottomSheetBehavior.state = (BottomSheetBehavior.STATE_HIDDEN)

        if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
        } else {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
        }

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
//                        buttonSlideUp.text = "Slide Up"
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {

                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
//                        buttonSlideUp.text = "Slide Down"
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {

                    }
                    BottomSheetBehavior.STATE_SETTLING -> {

                    }
                }
            }
        }
        )
    }

    private fun slideUpDownBottomSheet() {
        if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
//            buttonSlideUp.text = "Slide Down";
        } else {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED;
//            buttonSlideUp.text = "Slide Up"
        }
    }


    private fun bind(view: View) {
        textViewCategoryIncome = view.findViewById(R.id.text_view_category_income)
        bottomSheetLayout = view.findViewById(R.id.bottom_sheet_category_layout)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.text_view_category_income -> {
                val bottomSheetDialogFragment: BottomSheetDialogFragment =
                    BottomSheetCategoryFragment()
                activity?.supportFragmentManager?.let { it1 ->
                    bottomSheetDialogFragment.show(
                        it1, bottomSheetDialogFragment.tag
                    )
                }
            }


        }
    }

}

