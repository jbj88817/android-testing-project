package com.teamtreehouse.testingbase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bojiejiang on 2/4/17.
 */
public class MainActivityPresenterTest {

    MainActivityPresenter presenter;
    MainActivityView view;

    class MockedView implements MainActivityView {

        String textViewTest;

        @Override
        public void changeTextViewText(String text) {
            textViewTest = text;
        }

        @Override
        public void changeBackgroundColor(int color) {

        }

        @Override
        public void launchOtherActivity(Class activity) {

        }
    }


    @Before
    public void setUp() throws Exception {
        view = new MockedView();
        presenter = new MainActivityPresenter(view);
    }

    @Test
    public void editTextUpdate() throws Exception {
        // Arrange
        String givenString = "test123";

        // Act
        presenter.editTextUpdate(givenString);

        // Assert
        assertEquals(givenString, ((MockedView) view).textViewTest);
    }

    @Test
    public void colorSelected() throws Exception {

    }

    @Test
    public void launchOtherActvityButtonCliched() throws Exception {

    }

}