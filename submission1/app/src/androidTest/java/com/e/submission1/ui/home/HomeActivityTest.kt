package com.e.submission1.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.e.submission1.R
import com.e.submission1.utils.DataDummy
import org.junit.Rule
import org.junit.Test
import java.text.SimpleDateFormat

class HomeActivityTest{
    private val dummyMovies = DataDummy.generatedDummyMovie()
    private val dummyTvShow = DataDummy.generatedDummyTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

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
        onView(withId(R.id.title)).check(matches(withText(dummyMovies[0].title)))

        onView(withId(R.id.date)).check(matches(isDisplayed()))
        onView(withId(R.id.date)).check(matches(withText(SimpleDateFormat("dd MMMM yyyy").format(SimpleDateFormat("MM/dd/yyyy").parse(dummyMovies[0].date)).toString())))

        onView(withId(R.id.scrollview)).perform(swipeUp())
        onView(withId(R.id.description)).check(matches(isDisplayed()))
        onView(withId(R.id.description)).check(matches(withText(dummyMovies[0].description)))
    }

    @Test
    fun loadDetailTvShow(){
        onView(withId(R.id.tvshow)).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            ViewActions.click()
        ))
        onView(withId(R.id.title)).check(matches(isDisplayed()))
        onView(withId(R.id.title)).check(matches(withText(dummyTvShow[0].title)))

        onView(withId(R.id.date)).check(matches(isDisplayed()))
        onView(withId(R.id.date)).check(matches(withText(SimpleDateFormat("dd MMMM yyyy").format(SimpleDateFormat("MM/dd/yyyy").parse(dummyTvShow[0].date)).toString())))

        onView(withId(R.id.scrollview)).perform(swipeUp())
        onView(withId(R.id.description)).check(matches(isDisplayed()))
        onView(withId(R.id.description)).check(matches(withText(dummyTvShow[0].description)))
    }
}