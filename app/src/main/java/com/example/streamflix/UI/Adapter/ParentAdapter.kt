package com.example.streamflix.UI.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.streamflix.Model.CarouselData
import com.example.streamflix.Model.VideoItem
import com.example.streamflix.databinding.ItemCarouselParentBinding

class ParentAdapter(
    private val collections: List<CarouselData>,
    private val onVideoClick: (VideoItem) -> Unit
) : RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {

    inner class ParentViewHolder(val binding: ItemCarouselParentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        return ParentViewHolder(
            ItemCarouselParentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val section = collections[position]
        holder.binding.tvTitle.text = section.title

        val childAdapter = ChildAdapter(section.type, section.items, onVideoClick)
        holder.binding.rvChild.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = childAdapter
        }
    }

    override fun getItemCount(): Int = collections.size
}