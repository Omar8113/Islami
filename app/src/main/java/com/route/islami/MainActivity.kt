package com.route.islami

import RadioFragment
import SebhaFragment
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.route.islami.databinding.ActivityMainBinding
import com.route.islami.tabs.Quran.QuranFragment
import com.route.islami.tabs.hadith.HadithFragment

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavView.selectedItemId = R.id.quran
        showFragment(QuranFragment())
        binding.bottomNavView.setOnItemSelectedListener { menuItem ->
            val fragment: Fragment
            if (menuItem.itemId == (R.id.quran)) {
                fragment = QuranFragment()
            } else if (menuItem.itemId == (R.id.hadith)) {
                fragment = HadithFragment()
            } else if (menuItem.itemId == (R.id.sebha)) {
                fragment = SebhaFragment()
            } else if (menuItem.itemId == (R.id.radio)) {
                fragment = RadioFragment()
            } else {
                fragment = RadioFragment()
            }
            showFragment(fragment)
            return@setOnItemSelectedListener true
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
