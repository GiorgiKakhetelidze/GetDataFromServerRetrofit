package com.example.shemajamebeli6.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.extensions.setImage
import com.example.shemajamebeli6.databinding.AnnouncementItemBinding
import com.example.shemajamebeli6.model.ContentItem

class AnnouncementAdapter : RecyclerView.Adapter<AnnouncementAdapter.ItemVieHolder>() {

    var data: List<ContentItem> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemVieHolder(
        binding = AnnouncementItemBinding.inflate(LayoutInflater.from(parent.context))
    )

    override fun onBindViewHolder(holder: ItemVieHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = data.size

    inner class ItemVieHolder(private val binding: AnnouncementItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        lateinit var curItem: ContentItem

        fun bind() {
            curItem = data[adapterPosition]
            binding.descriptionKATxtView.text = curItem.descriptionKA
            binding.publishDateTxtView.text = curItem.publishDate
            binding.titleKATxtView.text = curItem.titleKA
            Glide.with(itemView)
            binding.coverImgView.setImage(curItem.cover)
        }

    }

}