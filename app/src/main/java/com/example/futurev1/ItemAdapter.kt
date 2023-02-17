package com.example.futurev1

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.futurev1.databinding.RowBinding
import com.squareup.picasso.Picasso
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

class ItemAdapter(val item : MutableList<Item>) : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {
    //var itemList = ArrayList<Item>()


    class ItemHolder(item: View) : RecyclerView.ViewHolder(item){

        val binding = RowBinding.bind(item)

        fun bind(item : Item){
           // var data = MainActivity()
           // data.readJson()
            Picasso.get().load(item.iconUrl).into(binding.icon)
            binding.name.text = item.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        return holder.bind(item[position])
    }

    override fun getItemCount(): Int {
        return item.size
    }

//    fun addItem(item : Item){
//        itemList.add(item)
//        notifyDataSetChanged()
//    }

}