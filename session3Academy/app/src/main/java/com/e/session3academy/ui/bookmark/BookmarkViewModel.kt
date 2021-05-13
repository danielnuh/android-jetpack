package com.e.session3academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.e.session3academy.data.CourseEntity
import com.e.session3academy.utils.DataDummy

class BookmarkViewModel:ViewModel() {
    fun getBookmarks():List<CourseEntity> = DataDummy. generateDummyCourses()
}