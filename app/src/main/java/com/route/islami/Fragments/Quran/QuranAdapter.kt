package com.route.islami.Fragments.Quran

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.Chapter
import com.route.islami.databinding.ItemSurahBinding

class QuranAdapter(val chapters: List<Chapter>) : RecyclerView.Adapter<QuranAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemSurahBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSurahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chapter: Chapter = chapters[position]
        holder.binding.enSuraNameTv.text = chapter.en_title
        holder.binding.arSuraNameTv.text = chapter.ar_title
        holder.binding.versesNumTv.text = chapter.versesNumber
        holder.binding.suraNumberTv.text = "${(chapter.index) + 1}"
    }

    override fun getItemCount(): Int = chapters.size


}