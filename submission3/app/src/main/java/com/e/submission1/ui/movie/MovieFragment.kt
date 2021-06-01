package com.e.submission1.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.submission1.databinding.FragmentMovieBinding
import com.e.submission1.ui.tvShow.TvShowState
import com.e.submission1.viewModel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class MovieFragment : Fragment() {

    private lateinit var binding:FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity!=null){
            val viewModel = ViewModelProvider(this, ViewModelFactory.getInstance(requireActivity()))[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter()

            viewModel.getData().observe(viewLifecycleOwner,{data ->
                movieAdapter.setData(data)
                movieAdapter.notifyDataSetChanged()
            })

            with(binding.rvMovie){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }

            viewModel.state.observer(viewLifecycleOwner){
                when(it){
                    is MovieState.OnMassage->{
                        Snackbar.make(view, it.message, Snackbar.LENGTH_SHORT).show()
                    }

                    is MovieState.OnLoading->{
                        if (it.boolean){
                            binding.progressBar.visibility = View.VISIBLE
                        }else{
                            binding.progressBar.visibility = View.GONE
                        }
                    }

                    is MovieState.OnShowData->{
                        if (it.boolean){
                            binding.rvMovie.visibility = View.VISIBLE
                        }else{
                            binding.rvMovie.visibility = View.GONE
                        }
                    }

                    is MovieState.IsEmpty->{
                        if (it.boolean){
                            binding.textEmpty.visibility = View.VISIBLE
                        }else{
                            binding.textEmpty.visibility = View.GONE
                        }
                    }
                }
            }
        }
    }

}