package com.e.list.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.e.list.R
import com.e.list.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = HomePagerAdapter(supportFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter


        binding.viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (position == 0) binding.bottomNavbar.selectedItemId = R.id.movie
                else if (position == 1) binding.bottomNavbar.selectedItemId = R.id.tvshow
                else if (position == 2) binding.bottomNavbar.selectedItemId = R.id.favorite
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

                R.id.favorite->{
                    binding.viewPager.currentItem = 2
                    true
                }

                else -> false
            }
        }
    }
}