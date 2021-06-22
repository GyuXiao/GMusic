package com.gyu.gmusic.ui.base;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.gyu.gmusic.R;

/**
 * @author: zk.xiao
 * @email: {zk.xiao@aftership.com}
 * @date: 2021/6/23
 */
public class BaseActivity extends AppCompatActivity {

    private long exitTime = 0;

    private static final int DEFAULT_EXIT_DURATION = 2000;

    protected boolean isSureToExitAfterDoubleClick(View view, String tip, int duration) {
        if ((System.currentTimeMillis() - exitTime) > duration) {
            Snackbar.make(view, tip, Snackbar.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
            return true;
        } else {
            return false;
        }
    }

    protected boolean isSureToExitAfterDoubleClick() {
        return isSureToExitAfterDoubleClick(
                getWindow().getDecorView().findViewById(R.id.fragment_container),
                getString(R.string.exit_tip), DEFAULT_EXIT_DURATION);
    }
}
