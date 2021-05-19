package com.e.session3academy.ui.reader

import androidx.lifecycle.ViewModel
import com.e.session3academy.data.ModuleEntity
import com.e.session3academy.viewModel.AcademyRepository

class CourseReaderViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    private lateinit var courseId: String
    private lateinit var moduleId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun setSelectedModule(moduleId: String) {
        this.moduleId = moduleId
    }

    fun getModules(): List<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId)
            ;

    fun getSelectedModule(): ModuleEntity = academyRepository.getContent(courseId, moduleId)
}