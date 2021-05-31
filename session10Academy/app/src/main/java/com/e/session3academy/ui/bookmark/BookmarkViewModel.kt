package com.e.session3academy.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.e.session3academy.data.CourseEntity
import com.e.session3academy.viewModel.AcademyRepository

class BookmarkViewModel(private val academyRepository: AcademyRepository):ViewModel() {
    fun getBookmarks():LiveData<List<CourseEntity>> = academyRepository.getBookmarkedCourses()
}