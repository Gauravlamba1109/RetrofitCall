package com.example.retrofitcall

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MAdapter(val context: MainActivity, val innerdatalist: List<DataClass>):
    RecyclerView.Adapter<MAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var desct: TextView = itemView.findViewById(R.id.desct)
        var linkt: TextView= itemView.findViewById(R.id.linkt)
        var container = itemView.findViewById<LinearLayout>(R.id.container)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.desct.text = innerdatalist[position].Description
        holder.linkt.text = innerdatalist[position].Link
        var color = "#71e058"
        holder.container.setBackgroundColor(Color.parseColor(color))
    }

    override fun getItemCount(): Int {
        return innerdatalist.size
    }
}