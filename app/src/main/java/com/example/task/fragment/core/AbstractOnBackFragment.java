package com.example.task.fragment.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task.activity.MainActivity;
import com.example.task.listener.OnBackPressedListener;

/**
 * Created by Misha Dichuk on 28.05.16.
 */
public class AbstractOnBackFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }

    /**
     * method for finish screen
     */
    public void onActivityBaskPressed() {
        getActivity().finish();
    }

    /**
     * method for registration on back activity
     */
    public void registrationOnBackPressedListener() {
        ((MainActivity) getActivity()).setBackPressedListener(new OnBackPressedListener() {
            @Override
            public void onBaskPressedListener() {
                onActivityBaskPressed();
            }
        });
    }
}
