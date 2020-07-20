package com.app.bubbledemoapp.ui.mainmodule.bottomsheetmodule

import android.app.Activity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.bubbledemoapp.R
import com.app.bubbledemoapp.ShiftApplication.Companion.applicationContext
import com.app.bubbledemoapp.Utils.DialogUtils
import com.app.bubbledemoapp.core.presentation.base.BaseFragment
import com.app.bubbledemoapp.databinding.FragmentBottomSheetBinding
import com.app.bubbledemoapp.ui.mainmodule.bottomsheetmodule.adapter.ColorAdapter
import com.app.bubbledemoapp.ui.mainmodule.bottomsheetmodule.adapter.FeaturesAdapter
import com.app.bubbledemoapp.ui.mainmodule.bottomsheetmodule.adapter.SizeAdapter
import com.app.bubbledemoapp.ui.mainmodule.bottomsheetmodule.model.ProductModelPojo
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class BottomSheetFragment : BaseFragment<FragmentBottomSheetBinding, BottomSheetViewModel>(),
    BottomSheetNavigator, ColorAdapter.ColorListner, SizeAdapter.SizeListner {

    private var fragmentBottomSheetBinding: FragmentBottomSheetBinding? = null
    private val bottomSheetViewModel: BottomSheetViewModel by viewModel()
    private var bottomSheetNavigator: BottomSheetNavigator? = null
    private var db: FirebaseFirestore? = null
    private  var colorAdapter: ColorAdapter? = null
    private  var sizeAdapter: SizeAdapter? = null
    private var featuresAdapter: FeaturesAdapter? = null
    private  var count_qty = 0
    private  var imageLoad=""

    override fun getLayoutId(): Int {
        return R.layout.fragment_bottom_sheet
    }

    override fun getViewModel(): BottomSheetViewModel {
        return bottomSheetViewModel
    }

    override fun setUp(view: View, savedInstanceState: Bundle?) {
        fragmentBottomSheetBinding = getViewDataBinding()
        fragmentBottomSheetBinding!!.bottomSheetCall = this
        bottomSheetNavigator = this
        db = FirebaseFirestore.getInstance()
        bottomSheetViewModel?.getProductList(db!!)
            ?.observe(this, Observer { productModelPojo ->
                if (productModelPojo != null) {
                    initView(productModelPojo)
                } else {

                }
            })
    }

    private fun initView(productModelPojo: ProductModelPojo?) {
        Glide.with(activity!!)
            .load(productModelPojo?.image)
            .placeholder(R.drawable.ic_launcher_background)
            .into(fragmentBottomSheetBinding!!.imgProduct)
        imageLoad = productModelPojo!!.image
        fragmentBottomSheetBinding!!.txtProductName.setText("" + productModelPojo?.desc)
        fragmentBottomSheetBinding!!.txtProductPrizeAfterOff.setText("₹" + productModelPojo?.price)
        fragmentBottomSheetBinding!!.txtProdActualPrize.setText("₹" + productModelPojo?.actualvalue)
        fragmentBottomSheetBinding!!.txtOffPercentage.setText("" + productModelPojo?.discount)
        fragmentBottomSheetBinding!!.txtProductDesc.setText("" + "मुफ्त शिपिंग | कोरोना वायरस के करन डिलीवरी मे डेरि हो सक्ती है!")
        fragmentBottomSheetBinding!!.edtQtyResult.setText("" + count_qty)
        setColorAdapter(productModelPojo)
        setSizeAdapter(productModelPojo)
        setFeaturesAdapter(productModelPojo)


    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog

        if (dialog != null) {
            dialog?.also {
                val bottomSheet = dialog.findViewById<View>(R.id.design_bottom_sheet)
                bottomSheet.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
                val behavior = BottomSheetBehavior.from<View>(bottomSheet)
                val displayMetrics = DisplayMetrics()
                (context as Activity?)!!.windowManager.defaultDisplay.getMetrics(displayMetrics)
                val height = displayMetrics.heightPixels

                behavior.peekHeight = height * 2 / 3 //replace to whatever you want
                view?.requestLayout()
            }
        }
    }

    private fun setFeaturesAdapter(productModelPojo: ProductModelPojo?) {
        featuresAdapter =
            FeaturesAdapter(
                activity!!,
                productModelPojo!!.features as ArrayList<String>
            )
        fragmentBottomSheetBinding!!.recyclerProductDesc.layoutManager =
            LinearLayoutManager(activity!!, RecyclerView.VERTICAL, false)
        fragmentBottomSheetBinding!!.recyclerProductDesc.adapter = featuresAdapter
    }

    private fun setSizeAdapter(productModelPojo: ProductModelPojo?) {
        sizeAdapter =
            SizeAdapter(
                activity!!,
                productModelPojo!!.size as ArrayList<String>,
                this
            )
        fragmentBottomSheetBinding!!.recyclerViewSize.layoutManager =
            LinearLayoutManager(activity!!, RecyclerView.HORIZONTAL, false)
        fragmentBottomSheetBinding!!.recyclerViewSize.adapter = sizeAdapter

    }

    private fun setColorAdapter(productModelPojo: ProductModelPojo?) {

        colorAdapter =
            ColorAdapter(
                activity!!,
                productModelPojo!!.color as ArrayList<String>,
                this
            )
        fragmentBottomSheetBinding!!.recyclerViewColor.layoutManager =
            LinearLayoutManager(activity!!, RecyclerView.HORIZONTAL, false)
        fragmentBottomSheetBinding!!.recyclerViewColor.adapter = colorAdapter

    }

    override fun onCLickOnColor(position: Int, taxrate: String) {
        Log.e("Color", "" + taxrate)
        if (taxrate.equals("Maroon")) {
            Glide.with(activity!!)
                .load(imageLoad)
                .placeholder(R.drawable.ic_launcher_background)
                .into(fragmentBottomSheetBinding!!.imgProduct)
        } else if (taxrate.equals("Yellow")) {
            fragmentBottomSheetBinding!!.imgProduct.setImageResource(R.drawable.yellow_shirt)
        } else if (taxrate.equals("Black")) {
            fragmentBottomSheetBinding!!.imgProduct.setImageResource(R.drawable.black_shirt)
        } else if (taxrate.equals("Green")) {
            fragmentBottomSheetBinding!!.imgProduct.setImageResource(R.drawable.green_shirt)
        } else {

        }

    }

    override fun onSizeClick(position: Int, taxrate: String) {
        val toast = Toast. makeText(applicationContext, "You Selected T-Shirt size is" +taxrate, Toast. LENGTH_LONG)
        toast.show()
    }

    override fun clickOnPlus() {
        count_qty += 1
        fragmentBottomSheetBinding!!.edtQtyResult.setText("" + count_qty)
    }

    override fun clickOnMius() {
        if (count_qty > 0) {
            count_qty -= 1
            fragmentBottomSheetBinding!!.edtQtyResult.setText("" + count_qty)
        }
    }

    override fun clickOnBuyNow() {

    }

    override fun clickOnAddtocart() {

    }

}