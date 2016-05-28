package com.example.task.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.task.R;
import com.example.task.controller.FragmentNavigationManagerController;
import com.example.task.fragment.HomeFragment;
import com.example.task.listener.OnBackPressedListener;

public class MainActivity extends AppCompatActivity {

    public OnBackPressedListener backPressedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentNavigationManagerController.navigationFragment(this, new HomeFragment(), getString(R.string.home_fragment));
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
