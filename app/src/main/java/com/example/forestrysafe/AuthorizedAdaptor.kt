package com.example.forestrysafe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.forestrysafe.model.Feeder
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class AuthorizedAdaptor(val feeders: List<Feeder>): RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {
        return feeders.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.recyclerview_item, parent, false)
        println(feeders)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val feederNum = feeders.get(position).id
        val feederType = feeders.get(position).type
        val fid = holder.view.findViewById<TextView>(R.id.textViewLarge)
        val ftp = holder.view.findViewById<TextView>(R.id.textViewSmall)
        fid.setText(feederNum.toString())
        ftp.setText(feederType)
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){

}