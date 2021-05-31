package com.e.session3academy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.e.session3academy.data.source.local.entity.CourseEntity
import com.e.session3academy.data.source.AcademyRepository
import com.e.session3academy.vo.Resource

class AcademyViewModel(private val academyRepository: AcademyRepository):ViewModel() {
    fun getCourses(): LiveData<Resource<List<CourseEntity>>> = academyRepository.getAllCourses()
}