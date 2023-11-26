package com.example.dummy.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dummy.databinding.ItemBinding
import com.example.dummy.models.Response

class CountryAdapter( var  list : ArrayList<Response>) : RecyclerView.Adapter<CountryAdapter.viewHolder>(){
    class viewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val  binding =ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.d("TAG--->",list.size.toString())
        return list.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.binding.name.text=list[position].name
        holder.binding.title.text=list[position].iso
    }

}