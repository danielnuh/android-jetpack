package com.e.session3academy.ui.bookmark

import junit.framework.Assert.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class BookmarkViewModelTest{
    private lateinit var viewModel:BookmarkViewModel

    @Before
    fun setup(){
        viewModel = BookmarkViewModel()
    }

    @Test
    fun getBookmark(){
        val courseEntities = viewModel.getBookmarks()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}
