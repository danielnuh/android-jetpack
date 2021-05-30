package com.e.submission1.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.e.submission1.R
import com.e.submission1.utils.DataDummy
import com.e.submission1.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest{
    private val dummyMovies = DataDummy.generatedDummyMovie()
    private val dummyTvShow = DataDummy.generatedDummyTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size-1))

    }

    @Test
    fun loadTvShow() {
        onView(withId(R.id.tvshow)).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshow))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size-1))
    }
    @Test
    fun loadDetailMovie(){
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            ViewActions.click()
        ))
        onView(withId(R.id.title)).check(matches(isDisplayed()))

        onView(withId(R.id.date)).check(matches(isDisplayed()))

        onView(withId(R.id.scrollview)).perform(swipeUp())
        onView(withId(R.id.description)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailTvShow(){
        onView(withId(R.id.tvshow)).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            ViewActions.click()
        ))
        onView(withId(R.id.title)).check(matches(isDisplayed()))

        onView(withId(R.id.date)).check(matches(isDisplayed()))

        onView(withId(R.id.scrollview)).perform(swipeUp())
        onView(withId(R.id.description)).check(matches(isDisplayed()))
    }
}