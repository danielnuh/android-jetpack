package com.e.list.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.e.list.R
import com.e.list.utils.DataDummy
import com.e.list.utils.EspressoIdlingResource
import org.hamcrest.CoreMatchers.not
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
        Espresso.onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size-1))

    }

    @Test
    fun loadDetailMovie(){
        Espresso.onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            ViewActions.click()
        ))
        Espresso.onView(withId(R.id.title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(withId(R.id.date)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(withId(R.id.scrollview)).perform(ViewActions.swipeUp())
        Espresso.onView(withId(R.id.description))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

    @Test
    fun loadTvShow() {
        Espresso.onView(withId(R.id.tvshow)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tvshow))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_tvshow))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size-1))
    }



    @Test
    fun loadDetailTvShow(){
        Espresso.onView(withId(R.id.tvshow)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            ViewActions.click()
        ))
        Espresso.onView(withId(R.id.title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(withId(R.id.date)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(withId(R.id.scrollview)).perform(ViewActions.swipeUp())
        Espresso.onView(withId(R.id.description))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(withId(R.id.btn_favorite)).perform(ViewActions.click())
    }

    @Test
    fun checkFavorite(){
        Espresso.onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            ViewActions.click()
        ))
        Espresso.onView(withId(R.id.btn_favorite)).perform(ViewActions.click())

        Espresso.pressBack()

        Espresso.onView(withId(R.id.tvshow)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            ViewActions.click()
        ))
        Espresso.onView(withId(R.id.btn_favorite)).perform(ViewActions.click())

        Espresso.pressBack()

        Espresso.onView(withId(R.id.favorite)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_fav_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(withId(R.id.view_fav_pager)).perform(ViewActions.swipeLeft())

        Espresso.onView(withId(R.id.rv_fav_tvshow))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(withId(R.id.movie)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            ViewActions.click()
        ))
        Espresso.onView(withId(R.id.btn_favorite)).perform(ViewActions.click())

        Espresso.pressBack()

        Espresso.onView(withId(R.id.tvshow)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            ViewActions.click()
        ))
        Espresso.onView(withId(R.id.btn_favorite)).perform(ViewActions.click())

        Espresso.pressBack()

        Espresso.onView(withId(R.id.favorite)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_fav_movie))
            .check(ViewAssertions.matches(not(ViewMatchers.isDisplayed())))

        Espresso.onView(withId(R.id.view_fav_pager)).perform(ViewActions.swipeLeft())

        Espresso.onView(withId(R.id.rv_fav_tvshow))
            .check(ViewAssertions.matches(not(ViewMatchers.isDisplayed())))
    }
}