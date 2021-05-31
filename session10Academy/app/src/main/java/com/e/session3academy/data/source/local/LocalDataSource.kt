package com.e.session3academy.data.source.local

import androidx.lifecycle.LiveData
import com.e.session3academy.data.source.local.entity.CourseEntity
import com.e.session3academy.data.source.local.entity.ModuleEntity
import com.e.session3academy.data.source.local.entity.CourseWithModule
import com.e.session3academy.data.source.local.room.AcademyDao

class LocalDataSource private constructor(private val mAcademyDao: AcademyDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(academyDao: AcademyDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(academyDao)
    }

    fun getAllCourse(): LiveData<List<CourseEntity>> = mAcademyDao.getCourses()

    fun getBookmarkedCourses(): LiveData<List<CourseEntity>> = mAcademyDao.getBookmakedCourse()

    fun getCourseWithModules(courseId: String): LiveData<CourseWithModule> =
        mAcademyDao.getCourseWithModuleById(courseId)

    fun getAllModulesByCourse(courseId: String): LiveData<List<ModuleEntity>> =
        mAcademyDao.getModuleByCourseId(courseId)

    fun insertCourse(course: List<CourseEntity>) = mAcademyDao.insertCourse(course)

    fun insertModule(module: List<ModuleEntity>) = mAcademyDao.insertModules(module)

    fun setCourseBookmark(course: CourseEntity, newState: Boolean) {
        course.bookmarked = newState
        mAcademyDao.updateCourse(course)
    }

    fun getModuleWithContent(moduleId: String) = mAcademyDao.getModuleById(moduleId)

    fun updateContent(content: String, moduleId: String) =
        mAcademyDao.updateModuleByContent(content, moduleId)

    fun setReadModule(module: ModuleEntity) {
        module.read = true
        mAcademyDao.updateModule(module)
    }
}