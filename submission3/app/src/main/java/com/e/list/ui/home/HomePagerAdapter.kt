package com.e.list.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.e.list.ui.favorite.FavoriteFragment
import com.e.list.ui.movie.MovieFragment
import com.e.list.ui.tvshow.TvShowFragment

@Suppress("DEPRECATION")
class HomePagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MovieFragment()
            1 -> TvShowFragment()
            2 -> FavoriteFragment()
            else -> Fragment()
        }
    }
}