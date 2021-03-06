package com.e.session3academy.ui.reader.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.session3academy.data.source.local.entity.ModuleEntity
import com.e.session3academy.databinding.FragmentModuleListBinding
import com.e.session3academy.ui.reader.CourseReaderActivity
import com.e.session3academy.ui.reader.CourseReaderCallback
import com.e.session3academy.ui.reader.CourseReaderViewModel
import com.e.session3academy.viewModel.ViewModelFactory
import com.e.session3academy.vo.Status

class ModuleListFragment : Fragment(), MyAdapterClickListener {

    companion object{
        val TAG:String = ModuleListFragment::class.java.simpleName
        fun newInstance() : ModuleListFragment = ModuleListFragment()
    }

    private lateinit var binding:FragmentModuleListBinding
    private lateinit var adapter: ModuleListAdapter
    private lateinit var courseReaderCallback: CourseReaderCallback

    private lateinit var viewModel: CourseReaderViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentModuleListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity(), ViewModelFactory.getInstance(requireActivity()))[CourseReaderViewModel::class.java]

        adapter = ModuleListAdapter(this)
        viewModel.modules.observe(viewLifecycleOwner, { moduleEntities ->
            if (moduleEntities != null) {
                when (moduleEntities.status) {
                    Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        binding?.progressBar?.visibility = View.GONE
                        populateRecyclerView(moduleEntities.data as List<ModuleEntity>)
                    }
                    Status.ERROR -> {
                        binding?.progressBar?.visibility = View.GONE
                        Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        courseReaderCallback = context as CourseReaderActivity
    }

    private fun populateRecyclerView(modules: List<ModuleEntity>) {
        with(binding) {
            progressBar.visibility = View.GONE
            adapter.setModules(modules)
            rvModule.layoutManager = LinearLayoutManager(context)
            rvModule.setHasFixedSize(true)
            rvModule.adapter = adapter
            val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            rvModule.addItemDecoration(dividerItemDecoration)
        }
    }

    override fun onItemClicked(position: Int, moduleId: String) {
        courseReaderCallback.moveTo(position,moduleId)
        viewModel.setSelectedModule(moduleId)
    }


}