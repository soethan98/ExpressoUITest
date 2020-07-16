package com.example.androidxuitest

import android.app.Instrumentation
import android.content.Intent
import android.graphics.BitmapFactory
import android.icu.text.DateTimePatternGenerator.PatternInfo.OK
import android.os.Bundle
import android.provider.MediaStore
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.androidxuitest.ImageViewHasDrawableMatcher.hasDrawable
import org.hamcrest.Matcher
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get:Rule
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)


    @Test
    fun test_cameraIntent() {

        //Given
        val activityResult = createImageCaptureActivityResultStub()
        val expected: Matcher<Intent> = hasAction(MediaStore.ACTION_IMAGE_CAPTURE)
        intending(expected).respondWith(activityResult)

        onView(withId(R.id.image)).check(matches(not(hasDrawable())))

        onView(withId(R.id.button_launch_camera)).perform(click())
        intending(expected)
        onView(withId(R.id.image)).check(matches(hasDrawable()))


    }

    private fun createImageCaptureActivityResultStub(): Instrumentation.ActivityResult? {
        val bundle = Bundle()
        bundle.putParcelable(
            KEY_IMAGE_DATA, BitmapFactory.decodeResource(
                intentsTestRule.activity.resources,
                R.drawable.ic_launcher_background
            )
        )

        val resultData = Intent()
        resultData.putExtras(bundle)
        return Instrumentation.ActivityResult(OK, resultData)


    }
}