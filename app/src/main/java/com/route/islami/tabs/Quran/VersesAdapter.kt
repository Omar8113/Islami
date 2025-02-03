package com.route.islami.tabs.Quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.databinding.ItemVerseBinding

class VersesAdapter(val verses: List<String>) : RecyclerView.Adapter<VersesAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemVerseBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemVerseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = verses.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.content.text = verses[position]
    }
}