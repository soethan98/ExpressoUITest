package com.example.androidxuitest

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testActivity_inView() {
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    //Visibilty
    @Test
    fun testVisibility_title_nextButton() {
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.activity_main_title)).check(matches(isDisplayed())) //method 1

        onView(withId(R.id.activity_main_title)).check(matches(withEffectiveVisibility(Visibility.VISIBLE))) //method 2

        onView(withId(R.id.button_next_activity))
            .check(matches(isDisplayed()))
    }

    //Text
    @Test
    fun testTitleTextDisplayed() {
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.activity_main_title)).check(matches(withText(R.string.text_mainactivity)))

    }

}