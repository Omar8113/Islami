package com.route.islami.Fragments.Quran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami.Fragments.AppConstants
import com.route.islami.databinding.FragmentQuranBinding

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
        binding.quranRv.adapter = adapter
    }
}
