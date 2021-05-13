package com.e.session3academy.ui.reader.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.e.session3academy.data.ContentEntity
import com.e.session3academy.data.ModuleEntity
import com.e.session3academy.databinding.FragmentModuleContentBinding
import com.e.session3academy.ui.reader.CourseReaderViewModel

class ModuleContentFragment : Fragment() {
    companion object{
        val TAG: String  = ModuleContentFragment::class.java.simpleName
        fun newInstance(): ModuleContentFragment =  ModuleContentFragment()
    }

    private lateinit var fragmentModuleContentBinding:FragmentModuleContentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentModuleContentBinding = FragmentModuleContentBinding.inflate(inflater, container, false)
        return fragmentModuleContentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            val viewModel = ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory())[CourseReaderViewModel::class.java]
            val module = viewModel.getSelectedModule()
            populateWebView(module)
        }


    }

    private fun populateWebView(content: ModuleEntity) {
        fragmentModuleContentBinding.webView.loadData(content.contentEntity?.content ?: "", "text/html", "UTF-8")
    }
}