package com.example.expandablecardview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expandablecardview.databinding.ItemRecyclerListBinding

class AdapterDetails(
    val context: Context,
    val dataList: MutableList<ItemExercises>
) : RecyclerView.Adapter<AdapterVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterVH {
        return AdapterVH(
            ItemRecyclerListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AdapterVH, position: Int) {
        val itemExercises = dataList[position]
        holder.binding.apply {
            exceriseName.text = itemExercises.name
            exerciseDetailsSubitem.text = itemExercises.description
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}