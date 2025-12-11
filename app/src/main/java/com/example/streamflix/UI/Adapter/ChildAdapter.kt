package com.example.streamflix.UI.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.streamflix.Model.CarouselType
import com.example.streamflix.Model.VideoItem
import com.example.streamflix.databinding.ItemCircleBinding
import com.example.streamflix.databinding.ItemHeroBinding
import com.example.streamflix.databinding.ItemLandscapeBinding
import com.example.streamflix.databinding.ItemPosterBinding

class ChildAdapter(
    private val type: CarouselType,
    private val items: List<VideoItem>,
    private val onClick: (VideoItem) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // ViewHolders for 4 different types
    inner class HeroVH(val b: ItemHeroBinding) : RecyclerView.ViewHolder(b.root)
    inner class PosterVH(val b: ItemPosterBinding) : RecyclerView.ViewHolder(b.root)
    inner class LandscapeVH(val b: ItemLandscapeBinding) : RecyclerView.ViewHolder(b.root)
    inner class CircleVH(val b: ItemCircleBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (type) {
            CarouselType.HERO -> HeroVH(ItemHeroBinding.inflate(layoutInflater, parent, false))
            CarouselType.POSTER -> PosterVH(ItemPosterBinding.inflate(layoutInflater, parent, false))
            CarouselType.LANDSCAPE -> LandscapeVH(ItemLandscapeBinding.inflate(layoutInflater, parent, false))
            CarouselType.CIRCLE -> CircleVH(ItemCircleBinding.inflate(layoutInflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        val imgView = when (holder) {
            is HeroVH -> { holder.b.root.setOnClickListener { onClick(item) }; holder.b.imgHero }
            is PosterVH -> { holder.b.root.setOnClickListener { onClick(item) }; holder.b.imgPoster }
            is LandscapeVH -> { holder.b.root.setOnClickListener { onClick(item) }; holder.b.imgLand }
            is CircleVH -> { holder.b.root.setOnClickListener { onClick(item) }; holder.b.imgCircle }
            else -> null
        }

        imgView?.let {
            var request = Glide.with(it.context).load(item.imageUrl)
            if (type == CarouselType.CIRCLE) request = request.apply(RequestOptions.circleCropTransform())
            request.into(it)
        }
    }

    override fun getItemCount(): Int = items.size
}