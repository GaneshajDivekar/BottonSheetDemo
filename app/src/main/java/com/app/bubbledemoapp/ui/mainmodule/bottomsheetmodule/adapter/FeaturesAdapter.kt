package com.app.bubbledemoapp.ui.mainmodule.bottomsheetmodule.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.bubbledemoapp.R
import java.util.ArrayList


class FeaturesAdapter(
    var context: Context,
    var arrayListColor: ArrayList<String>
) : RecyclerView.Adapter<FeaturesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.textView)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.feature_item_view,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return arrayListColor.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title!!.text = "" + arrayListColor[position]




    }
}