package com.e.session3academy.ui.academy

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AcademyViewModelTest{
    private lateinit var viewModel: AcademyViewModel

    @Before
    fun setUp(){
        viewModel = AcademyViewModel()
    }

    @Test
    fun getCourses(){
        val courseEntitys = viewModel.getCourses()

        assertNotNull(courseEntitys)
        assertEquals(5, courseEntitys.size)
    }
}