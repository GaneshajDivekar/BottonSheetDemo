package com.app.bubbledemoapp.ui.mainmodule.bottomsheetmodule

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.bubbledemoapp.Utils.DialogUtils
import com.app.bubbledemoapp.core.network.webservice.RetrofitCallAPI
import com.app.bubbledemoapp.core.network.webservice.WebServiceAPI
import com.app.bubbledemoapp.data.room.DatabaseHelper
import com.app.bubbledemoapp.ui.mainmodule.bottomsheetmodule.model.ProductModelPojo
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class BottonSheetRepository {
    companion object {
        var bottonSheetRepository: BottonSheetRepository? = null
        var mContext: Application? = null
        @Synchronized
        @JvmStatic
        fun getInstance(application: Application): BottonSheetRepository {
            mContext = application
            if (bottonSheetRepository == null) bottonSheetRepository = BottonSheetRepository()
            return bottonSheetRepository!!
        }
    }

    fun getProductListData(db: FirebaseFirestore): LiveData<ProductModelPojo> {
        val tempProductModelPojo = MutableLiveData<ProductModelPojo>()
        val docRef = db!!.collection("product").document("tQifPlrfGDLfqx6ww7pd")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    var productModelPojo: ProductModelPojo? = ProductModelPojo("",
                        emptyList(),"","",emptyList()
                        ,"",emptyList(),"")
                    productModelPojo = Gson().fromJson<ProductModelPojo>(
                        Gson().toJson(document.data),
                        ProductModelPojo::class.java
                    )

                    tempProductModelPojo.value = productModelPojo
                    System.out.println("Result="+productModelPojo)
                    //  (Gson().toJson(document.data))
                } else {
                    Log.d("TAG", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("TAG", "get failed with ", exception)
            }


        return tempProductModelPojo
    }


}
