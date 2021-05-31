package com.e.session3academy.ui.bookmark

import com.e.session3academy.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}