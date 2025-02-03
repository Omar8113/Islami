package com.route.islami.tabs.hadith

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.FullScreenCarouselStrategy
import com.route.islami.databinding.FragmentHadithBinding

class HadithFragment : Fragment() {
    lateinit var binding: FragmentHadithBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHadithBinding.inflate(inflater, container, false)
        return binding.root
    }

    val ahadith = mutableListOf<Hadith>()
    lateinit var adapter: HadithAdapter
    lateinit var layoutManager: CarouselLayoutManager
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readAhadith()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = HadithAdapter(ahadith)
        layoutManager = CarouselLayoutManager(
            FullScreenCarouselStrategy(),
            CarouselLayoutManager.HORIZONTAL
        )
        layoutManager.carouselAlignment = CarouselLayoutManager.ALIGNMENT_CENTER
        binding.hadithRecyclerView.adapter = adapter
        binding.hadithRecyclerView.layoutManager = layoutManager

        val snapHelper = CarouselSnapHelper()
        snapHelper.attachToRecyclerView(binding.hadithRecyclerView)

        binding.hadithRecyclerView.addItemDecoration(
            MarginItemDecoration(getMarginInPx())
        )
    }

    fun readAhadith() {
        val hadithContent =
            activity?.assets?.open("Ahadith/ahadeth.txt")?.bufferedReader().use { it?.readText() }
        if (hadithContent == null) return

        val hadithList = hadithContent.trim().split("#")
        hadithList.forEach { singleHadith ->
            val lines = singleHadith.trim().split("\n")
            val title = lines[0]
            val content = lines.takeLast(lines.size - 1).joinToString("\n")
            val hadith = Hadith(title, content)
            ahadith.add(hadith)
        }
    }

    fun getMarginInPx(): Int {
        val r = resources
        val px = Math.round(
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 24f, r.displayMetrics
            )
        )
        return px
    }
}
