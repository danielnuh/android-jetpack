package com.e.list.ui.favorite.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.list.R
import com.e.list.databinding.FragmentFavoriteMovieBinding
import com.e.list.ui.favorite.tvshow.FavoriteTvShowViewModel
import com.e.list.viewModel.ViewModelFactory

class FavoriteMovieFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentFavoriteMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            val vactory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, vactory)[FavoriteMovieViewModel::class.java]

            val favoriteMovieAdapter = FavoriteMovieAdapter()

            viewModel.getMovie().observe(viewLifecycleOwner, {
                if(it!=null){
                    if(it.isEmpty()){
                        binding.progressBar.visibility = View.GONE
                        binding.rvFavMovie.visibility = View.GONE
                        binding.textEmpty.visibility = View.VISIBLE
                    }else{
                        binding.progressBar.visibility = View.GONE
                        binding.rvFavMovie.visibility = View.VISIBLE
                        binding.textEmpty.visibility = View.GONE
                        favoriteMovieAdapter.submitList(it)
                    }
                }
            })

            with(binding.rvFavMovie){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = favoriteMovieAdapter
            }

        }
    }
}