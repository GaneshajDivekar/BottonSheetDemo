package com.app.bubbledemoapp.ui.mainmodule.bottomsheetmodule

import android.app.Application
import androidx.lifecycle.LiveData
import com.app.bubbledemoapp.core.presentation.base.BaseViewModel
import com.app.bubbledemoapp.ui.mainmodule.bottomsheetmodule.model.ProductModelPojo
import com.google.firebase.firestore.FirebaseFirestore

class BottomSheetViewModel(application: Application) : BaseViewModel(application) {
    fun getProductList(db: FirebaseFirestore) : LiveData<ProductModelPojo> {
        return BottonSheetRepository.getInstance(getApplication()).getProductListData(db)
    }
}