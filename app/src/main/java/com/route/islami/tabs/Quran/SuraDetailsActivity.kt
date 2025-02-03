package com.route.islami.tabs.Quran

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.route.islami.databinding.ActivitySuraDetailsBinding

class SuraDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivitySuraDetailsBinding
    var chapter: Chapter? = null
    lateinit var versesList: List<String>
    lateinit var adapter: VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initChapter()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = VersesAdapter(versesList)
        binding.suraRecyclerView.adapter = adapter
    }

    private fun initChapter() {
        chapter = intent.getParcelableExtra("Chapter")
        binding.toolbarTitle.text = chapter?.en_title
        binding.chapterTitleAr.text = chapter?.ar_title
        readChapterDetails(chapter?.index ?: 0)
    }

    fun readChapterDetails(chapterIndex: Int) {
        val content =
            assets.open("Quran/${chapterIndex + 1}.txt").bufferedReader().use { it.readText() }
        versesList = content.split("\n")
    }

}
