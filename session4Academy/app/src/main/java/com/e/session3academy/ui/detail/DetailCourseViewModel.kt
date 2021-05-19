package com.e.session3academy.ui.detail

import androidx.lifecycle.ViewModel
import com.e.session3academy.data.CourseEntity
import com.e.session3academy.data.ModuleEntity
import com.e.session3academy.viewModel.AcademyRepository

class DetailCourseViewModel(private val academyRepository: AcademyRepository):ViewModel() {
    private lateinit var courseId: String

    fun setSelectedCourse(courseId:String){
        this.courseId = courseId
    }

    fun getCourse():CourseEntity = academyRepository.getCourseWithModules(courseId)

    fun getModules():List<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId)

}