package com.e.session3academy.ui.academy

import androidx.lifecycle.ViewModel
import com.e.session3academy.data.CourseEntity
import com.e.session3academy.viewModel.AcademyRepository

class AcademyViewModel(private val academyRepository: AcademyRepository):ViewModel() {
    fun getCourses(): List<CourseEntity> = academyRepository.getAllCourses()
}