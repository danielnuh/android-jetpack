package com.e.session3academy.ui.bookmark

import com.e.session3academy.data.CourseEntity
import com.e.session3academy.utils.DataDummy
import com.e.session3academy.viewModel.AcademyRepository
import junit.framework.TestCase.assertNotNull
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BookmarkViewModelTest{
    private lateinit var viewModel:BookmarkViewModel

    @Mock
    private lateinit var academyRepository: AcademyRepository

    @Before
    fun setup(){
        viewModel = BookmarkViewModel(academyRepository)
    }

    @Test
    fun getBookmark(){
        `when`(academyRepository.getBookmarkedCourses()).thenReturn(DataDummy.generateDummyCourses())
        val courseEntities = viewModel.getBookmarks()
        verify(academyRepository).getBookmarkedCourses()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}
