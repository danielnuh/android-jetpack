package com.e.session3academy.ui.academy

import androidx.lifecycle.ViewModel
import com.e.session3academy.data.CourseEntity
import com.e.session3academy.utils.DataDummy

class AcademyViewModel:ViewModel() {
    fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourses()
}