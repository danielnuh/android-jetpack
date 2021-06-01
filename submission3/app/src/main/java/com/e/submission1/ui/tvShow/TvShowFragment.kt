package com.e.submission1.ui.tvShow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.submission1.databinding.FragmentTvShowBinding
import com.e.submission1.viewModel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class TvShowFragment : Fragment() {

    private lateinit var binding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelFactory.getInstance(requireActivity()))[TvShowViewModel::class.java]

            val tvShowAdapter = TvShowAdapter()

            viewModel.getData().observe(viewLifecycleOwner,{data->
                tvShowAdapter.setData(data)
                tvShowAdapter.notifyDataSetChanged()
            })

            with(binding.rvTvshow){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }

            viewModel.state.observer(viewLifecycleOwner){
                when(it){
                    is TvShowState.OnMassage->{
                        Snackbar.make(view, it.message, Snackbar.LENGTH_SHORT).show()
                    }

                    is TvShowState.OnLoading->{
                        if (it.boolean){
                            binding.progressBar.visibility = View.VISIBLE
                        }else{
                            binding.progressBar.visibility = View.GONE
                        }
                    }

                    is TvShowState.OnShowData->{
                        if (it.boolean){
                            binding.rvTvshow.visibility = View.VISIBLE
                        }else{
                            binding.rvTvshow.visibility = View.GONE
                        }
                    }

                    is TvShowState.IsEmpty->{
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