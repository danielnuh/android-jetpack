package com.e.submission1.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.e.submission1.R
import com.e.submission1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = PagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter

        binding.viewPager.addOnPageChangeListener(object:ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (position == 0) binding.bottomNavbar.selectedItemId = R.id.movie
                else if (position == 1) binding.bottomNavbar.selectedItemId = R.id.tvshow
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

        binding.bottomNavbar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.movie->{
                    binding.viewPager.currentItem = 0
                    true
                }

                R.id.tvshow->{
                    binding.viewPager.currentItem = 1
                    true
                }

                else -> false
            }
        }
    }
}