package com.teamtreehouse.testingbase;

/**
 * Created by bojiejiang on 2/4/17.
 */

public interface MainActivityView {
    void changeTextViewText(String text);

    void changeBackgroundColor(int color);

    void launchOtherActivity(Class activity);
}
