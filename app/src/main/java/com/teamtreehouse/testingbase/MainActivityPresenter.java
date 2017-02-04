package com.teamtreehouse.testingbase;

import android.graphics.Color;

/**
 * Created by bojiejiang on 2/4/17.
 */

public class MainActivityPresenter {
    MainActivityView view;

    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
    }

    public void editTextUpdate(String text) {
        view.changeTextViewText(text);
    }

    public void colorSelected(int index) {
        switch (index) {
            case 0:
                view.changeBackgroundColor(Color.WHITE);
                break;
            case 1:
                view.changeBackgroundColor(Color.MAGENTA);
                break;
            case 2:
                view.changeBackgroundColor(Color.GREEN);
                break;
            case 3:
                view.changeBackgroundColor(Color.CYAN);
                break;
        }
    }

    public void launchOtherActvityButtonCliched(Class actvity) {
        view.launchOtherActivity(actvity);
    }
}
