package com.route.islami.tabs.Quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami.databinding.FragmentQuranBinding
import com.route.islami.tabs.AppConstants

class QuranFragment : Fragment() {
    lateinit var binding: FragmentQuranBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    val chaptersList = AppConstants.getChapters()
    lateinit var adapter: QuranAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = QuranAdapter(chaptersList)
        adapter.onItemClick = QuranAdapter.OnItemClick { position, chapter ->
            val intent = Intent(activity, SuraDetailsActivity::class.java)
            intent.putExtra("Chapter", chapter)
            startActivity(intent)
        }
        binding.quranRv.adapter = adapter
    }
}
