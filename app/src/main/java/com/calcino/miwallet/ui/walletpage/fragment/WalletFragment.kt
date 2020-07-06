package com.calcino.miwallet.ui.walletpage.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.calcino.miwallet.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


/**

 */
class WalletFragment : Fragment(), View.OnClickListener {

    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var navController: NavController
    private lateinit var homeImage: ImageView
    private lateinit var walletImage: ImageView
    private lateinit var reportImage: ImageView
    private lateinit var resultImage: ImageView
    private lateinit var settingImage: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wallet, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
        clickListener()
        navController = Navigation.findNavController(view)
    }

    private fun clickListener() {
        floatingActionButton.setOnClickListener(this)
        homeImage.setOnClickListener(this)
        reportImage.setOnClickListener(this)
        resultImage.setOnClickListener(this)
        settingImage.setOnClickListener(this)
    }

    private fun bind(view: View) {
        floatingActionButton = view.findViewById(R.id.floatingActionButton_wallet)
        homeImage = view.findViewById(R.id.home_image_wallet)
        walletImage = view.findViewById(R.id.wallet_image_wallet)
        reportImage = view.findViewById(R.id.report_image_wallet)
        settingImage = view.findViewById(R.id.setting_image_wallet)
        resultImage = view.findViewById(R.id.result_image_wallet)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.home_image_wallet -> navController.navigate(R.id.action_walletFragment_to_homePageFragment22)
            R.id.report_image_wallet -> navController.navigate(R.id.action_walletFragment_to_reportFragment)
            R.id.result_image_wallet -> navController.navigate(R.id.action_walletFragment_to_resultFragment)
            R.id.setting_image_wallet -> navController.navigate(R.id.action_walletFragment_to_settingFragment)
            R.id.floatingActionButton_wallet -> {
            }
        }
    }
}