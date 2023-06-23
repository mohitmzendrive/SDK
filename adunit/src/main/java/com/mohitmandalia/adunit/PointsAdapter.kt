package com.mohitmandalia.adunit

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PointsAdapter(private var points: List<String>) :
    RecyclerView.Adapter<PointTextviewHolder>() {

    override fun getItemCount(): Int = points.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointTextviewHolder {
        val itemView = AdUnitStore.adUnitListItemContentBindingContract.inflate(parent)

        return PointTextviewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PointTextviewHolder, position: Int) {
        holder.bind(points[position])
    }
}

class PointTextviewHolder(val binding: AdUnitListItemContentBindingContract) :
    RecyclerView.ViewHolder(binding.containerView) {

    fun bind(string: String) {
        binding.adUnitContentTextView.text = string
    }
}