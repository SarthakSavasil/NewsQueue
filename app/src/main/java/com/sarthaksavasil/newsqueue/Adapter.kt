package com.sarthaksavasil.newsqueue

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyViewHolder> ()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.news_view, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder (itemView)
{

}