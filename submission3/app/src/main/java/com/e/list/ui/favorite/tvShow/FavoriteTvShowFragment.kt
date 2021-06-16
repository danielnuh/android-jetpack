package com.e.list.ui.favorite.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.list.R
import com.e.list.databinding.FragmentFavoriteTvShowBinding
import com.e.list.databinding.FragmentTvShowBinding
import com.e.list.ui.tvshow.TvShowAdapter
import com.e.list.viewModel.ViewModelFactory

class FavoriteTvShowFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentFavoriteTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            val vactory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, vactory)[FavoriteTvShowViewModel::class.java]

            val favoriteTvShowAdapter = FavoriteTvShowAdapter()

            viewModel.getTvShow().observe(viewLifecycleOwner, {
                if(it!=null){
                    if(it.isEmpty()){
                        binding.progressBar.visibility = View.GONE
                        binding.rvFavTvshow.visibility = View.GONE
                        binding.textEmpty.visibility = View.VISIBLE
                    }else{
                        binding.progressBar.visibility = View.GONE
                        binding.rvFavTvshow.visibility = View.VISIBLE
                        binding.textEmpty.visibility = View.GONE
                        favoriteTvShowAdapter.submitList(it)
                    }
                }
            })

            with(binding.rvFavTvshow){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = favoriteTvShowAdapter
            }
        }
    }
}