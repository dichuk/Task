package com.example.task.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.example.task.R;

/**
 * Created by Misha Dichuk on 28.05.16.
 */
public class FragmentNavigationManagerController {

    /**
     * method for fragment navigation  between screens
     *
     * @param activity
     * @param fragment
     * @param tag
     */
    public static void navigationFragment(FragmentActivity activity, Fragment fragment, String tag) {
        if (activity.getSupportFragmentManager().getBackStackEntryCount() > 0)
            activity.getSupportFragmentManager().popBackStackImmediate();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commitAllowingStateLoss();
    }
}
