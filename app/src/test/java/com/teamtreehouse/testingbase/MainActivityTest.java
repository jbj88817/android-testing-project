package com.teamtreehouse.testingbase;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.inputmethod.EditorInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by bojiejiang on 2/4/17.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class MainActivityTest {

    MainActivity mActivity;

    @Before
    public void setUp() {
        mActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void editTextUpdatesTestView() throws Exception {
        // Arrange
        String givenString = "test123";
        mActivity.editText.setText(givenString);

        // Act
        mActivity.editText.onEditorAction(EditorInfo.IME_ACTION_DONE);

        // Assert
        String actualString = mActivity.textView.getText().toString();
        assertEquals(givenString, actualString);
    }

    @Test
    public void spinnerUpdatesBackgroundColor() throws Exception {
        // Arrange
        int index = 2;
        int givenColor = Color.GREEN;

        // Act
        mActivity.colorSpinner.setSelection(index);

        // Assert
        int actualColor = ((ColorDrawable)mActivity.linearLayout.getBackground()).getColor();
        assertEquals(givenColor, actualColor);
    }

    @Test
    public void buttonLaunchesOtherActivity() throws Exception {
        // Arrange
        Class clazz = OtherActivity.class;
        Intent expectedIntent = new Intent(mActivity, clazz);

        // Act
        mActivity.launchActivityButton.callOnClick();

        // Assert
        ShadowActivity shadowActivity = Shadows.shadowOf(mActivity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(expectedIntent.filterEquals(actualIntent));
    }

}
