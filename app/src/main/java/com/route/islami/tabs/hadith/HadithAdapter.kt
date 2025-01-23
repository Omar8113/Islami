package com.route.islami.tabs.hadith

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.databinding.ItemHadithBinding

class HadithAdapter(val hadithList: List<Hadith>) :
    RecyclerView.Adapter<HadithAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemHadithBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hadith: Hadith) {
            binding.hadithTitle.text = hadith.title
            binding.hadithContent.text = hadith.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHadithBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = hadithList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadith = hadithList[position]
        holder.bind(hadith)
    }


}