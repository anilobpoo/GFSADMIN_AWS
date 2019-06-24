package com.obpoo.gfsfabricsoftware.utilities;

import android.animation.ObjectAnimator;
import android.view.View;

public class UiHelpers {
    public static void shakeView(View view) {
        ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "rotation", 0f, 20f, 0f, -20f, 0f);
        rotate.setRepeatCount(20); // repeat the loop 20 times
        rotate.setDuration(100); // animation play time 100 ms
        rotate.start();
    }
}
