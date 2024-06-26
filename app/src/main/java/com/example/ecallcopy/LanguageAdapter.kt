package com.example.searchviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecallcopy.R

class LanguageAdapter(var mList: List<LanguageData>) :
    RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logo : ImageView = itemView.findViewById(R.id.logoIv)
        val titleTv : TextView = itemView.findViewById(R.id.titleTv)
        val locationTv : TextView = itemView.findViewById(R.id.locationTv)
        val numberTV : TextView = itemView.findViewById(R.id.numberTv)
    }

    fun setFilteredList(mList: List<LanguageData>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item , parent , false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.logo.setImageResource(mList[position].logo)
        holder.titleTv.text = mList[position].title
        holder.titleTv.text = mList[position].title
        holder.locationTv.text = mList[position].location
        holder.locationTv.text = mList[position].location
        holder.numberTV.text = mList[position].number
        holder.numberTV.text = mList[position].number
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}