package com.e.session3academy.ui.reader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.e.session3academy.R
import com.e.session3academy.ui.reader.content.ModuleContentFragment
import com.e.session3academy.ui.reader.list.ModuleListFragment
import com.e.session3academy.viewModel.ViewModelFactory

class CourseReaderActivity : AppCompatActivity(),CourseReaderCallback {
    companion object {
        const val EXTRA_COURSE_ID = "extra_course_id"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_reader)

        val viewModel = ViewModelProvider(this, ViewModelFactory.getInstance(this))[CourseReaderViewModel::class.java]

        val bundle = intent.extras
        if (bundle != null) {
            val courseId = bundle.getString(EXTRA_COURSE_ID)
            if (courseId != null) {
                viewModel.setSelectedCourse(courseId)
                populateFragment()
            }
        }
    }

    private fun populateFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        var fragment = supportFragmentManager.findFragmentByTag(ModuleListFragment.TAG)
        if (fragment == null) {
            fragment = ModuleListFragment.newInstance()
            fragmentTransaction.add(R.id.frame_container, fragment, ModuleListFragment.TAG)
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }

    override fun moveTo(position: Int, moduleId: String) {
        val fragment = ModuleContentFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.frame_container, fragment, ModuleContentFragment.TAG)
            .addToBackStack(null)
            .commit()
    }
}