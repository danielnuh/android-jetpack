package com.e.list.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.list.databinding.FragmentTvShowBinding
import com.e.list.viewModel.ViewModelFactory
import com.e.list.vo.Status
import com.google.android.material.snackbar.Snackbar

class TvShowFragment : Fragment() {

    private lateinit var binding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            val vactory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, vactory)[TvShowViewModel::class.java]

            val tvShowAdapter = TvShowAdapter()

            viewModel.getTvShow().observe(viewLifecycleOwner, {result->
                if(result != null){
                    when(result.status){
                        Status.LOADING -> binding.progressBar.visibility = View.VISIBLE

                        Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            Snackbar.make(view, result.message!!, Snackbar.LENGTH_SHORT).show()
                        }

                        Status.SUCCESS->{
                            binding.progressBar.visibility = View.GONE
                            tvShowAdapter.submitList(result.data)
                        }
                    }
                }
            })

            with(binding.rvTvshow){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }

        }
    }
}