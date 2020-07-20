package com.app.bubbledemoapp.ui.mainmodule

import android.os.Bundle
import com.app.bubbledemoapp.R
import com.app.bubbledemoapp.core.presentation.base.BaseActivity
import com.app.bubbledemoapp.databinding.ActivityMainBinding
import com.app.bubbledemoapp.ui.mainmodule.bottomsheetmodule.BottomSheetFragment
import com.google.firebase.FirebaseApp
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {
    var activityMainBinding: ActivityMainBinding? = null
    val mainViewModel:MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = getViewDataBinding()
        activityMainBinding?.clickMeCallback = this
        FirebaseApp.initializeApp(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main

    }

    override fun getViewModel(): MainViewModel {
        return  mainViewModel

    }

    override fun setUp(savedInstanceState: Bundle?) {

    }

    override fun clickOnProceed() {
        val bottomSheet = BottomSheetFragment()
        bottomSheet.show(supportFragmentManager, "BottomSheetDialogFragment")
    }
}