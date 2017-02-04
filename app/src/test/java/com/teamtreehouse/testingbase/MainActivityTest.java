package com.teamtreehouse.testingbase;

import android.view.inputmethod.EditorInfo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bojiejiang on 2/4/17.
 */

public class MainActivityTest {

    MainActivity mActivity;

    @Before
    public void setUp() {
        mActivity = new MainActivity();
        mActivity.onCreate(null);
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

}
