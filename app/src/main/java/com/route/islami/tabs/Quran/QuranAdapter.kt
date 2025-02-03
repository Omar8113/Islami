package com.route.islami.tabs.Quran

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.databinding.ItemSurahBinding

class QuranAdapter(val chapters: List<Chapter>) : RecyclerView.Adapter<QuranAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemSurahBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(chapter: Chapter) {
            binding.enSuraNameTv.text = chapter.en_title
            binding.arSuraNameTv.text = chapter.ar_title
            binding.versesNumTv.text = chapter.versesNumber
            binding.suraNumberTv.text = "${(chapter.index) + 1}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSurahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chapter: Chapter = chapters[position]
        holder.bind(chapter)
        if (onItemClick != null) {
            holder.itemView.setOnClickListener {
                onItemClick!!.onItemClick(position, chapter)
            }
        }
    }

    override fun getItemCount(): Int = chapters.size

    var onItemClick: OnItemClick? = null

    fun interface OnItemClick {
        fun onItemClick(position: Int, chapter: Chapter)
    }


}