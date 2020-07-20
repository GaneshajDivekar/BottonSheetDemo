package com.app.bubbledemoapp.ui.mainmodule.bottomsheetmodule.model


import com.google.gson.annotations.SerializedName

data class ProductModelPojo(
    val actualvalue: String,
    val color: List<String>,
    val desc: String,
    val discount: String,
    @SerializedName("Features")
    val features: List<String>,
    val price: String,
    val size: List<String>,
    val image :String
)