package com.app.bubbledemoapp.ui.mainmodule.bottomsheetmodule.adapter

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.bubbledemoapp.R
import java.util.*

class SizeAdapter(
    var context: Context,
    var arrayListSize: ArrayList<String>,
    var taxratelistner: SizeListner
) : RecyclerView.Adapter<SizeAdapter.ViewHolder>() {
    private var selected: Int? = 0

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.uomadaptertitle)
    }

    interface SizeListner {
        fun onSizeClick(position: Int, taxrate: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.size_item_view,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return arrayListSize.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title!!.text = "" + arrayListSize[position]

        if (selected != null && selected == position) {
            holder.title!!.setTypeface(holder.title.getTypeface(), Typeface.BOLD)
            holder.title!!.background =
                context.resources.getDrawable(R.drawable.drawable_solid_orange_with_stork)
            holder.title!!.setTextColor(context.resources.getColor(R.color.light_orage))
        } else {
            holder.title!!.setTypeface(holder.title.getTypeface(), Typeface.NORMAL)
            holder.title!!.background =
                context.resources.getDrawable(R.drawable.drwable_gray_stroke)
            holder.title!!.setTextColor(context.resources.getColor(R.color.text_color))
        }

        holder.title!!.setOnClickListener {
            selected = position
            taxratelistner.onSizeClick(position, arrayListSize[position])
            notifyDataSetChanged()
        }
    }
}