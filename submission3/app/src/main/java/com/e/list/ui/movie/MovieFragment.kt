package com.e.list.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.list.databinding.FragmentMovieBinding
import com.e.list.viewModel.ViewModelFactory
import com.e.list.vo.Status
import com.google.android.material.snackbar.Snackbar

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            val vactory =ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, vactory)[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter()

            viewModel.getMovie().observe(viewLifecycleOwner, { result ->
                if(result != null){
                    when(result.status){
                        Status.LOADING -> binding.progressBar.visibility = View.VISIBLE

                        Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            Snackbar.make(view, result.message!!, Snackbar.LENGTH_SHORT).show()
                        }

                        Status.SUCCESS->{
                            binding.progressBar.visibility = View.GONE
                            movieAdapter.submitList(result.data)
                        }
                    }
                }
            })

            with(binding.rvMovie){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }


        }
    }
}