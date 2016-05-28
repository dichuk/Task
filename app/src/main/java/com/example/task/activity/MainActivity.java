package com.example.task.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.task.R;
import com.example.task.controller.FragmentNavigationManagerController;
import com.example.task.fragment.HomeFragment;
import com.example.task.listener.OnBackPressedListener;

public class MainActivity extends AppCompatActivity {

    public OnBackPressedListener backPressedListener;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String str = getString(R.string.home_fragment);
        if (getSupportFragmentManager().getBackStackEntryCount() > 0)
            str = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName();
        if (savedInstanceState != null) {
            fragment = getSupportFragmentManager().getFragment(savedInstanceState, str);
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStackImmediate();
            }
        } else {
            fragment = new HomeFragment();
        }
        FragmentNavigationManagerController.navigationFragment(this, fragment, str);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName(),
                getSupportFragmentManager().findFragmentByTag(getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName()));

    }

    @Override
    public void onBackPressed() {
        if (null != backPressedListener)
            backPressedListener.onBaskPressedListener();
        else
            this.finish();
    }

    /**
     * method for initialization back pressed
     *
     * @param backPressedListener
     */

    public void setBackPressedListener(OnBackPressedListener backPressedListener) {
        this.backPressedListener = backPressedListener;
    }
}
