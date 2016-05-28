package com.example.task.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.task.R;
import com.example.task.controller.FragmentNavigationManagerController;
import com.example.task.fragment.core.AbstractOnBackFragment;
import com.example.task.model.Task;

/**
 * Created by Misha Dichuk on 28.05.16.
 */
public class CreateTaskFragment extends AbstractOnBackFragment {
    private View view;
    private EditText edName, edComment;
    private Button btnBack, btnSave;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        registrationOnBackPressedListener();
        if (null == savedInstanceState) {
            view = inflater.inflate(R.layout.create_task_fragment, container, false);
            initializationViewElement();
        }
        return view;
    }

    /**
     * method for init view xml element
     */
    private void initializationViewElement() {
        edName = (EditText) view.findViewById(R.id.ed_name);
        edComment = (EditText) view.findViewById(R.id.ed_comment);
        btnBack = (Button) view.findViewById(R.id.btn_back);
        btnBack.setOnClickListener(clickListener);
        btnSave = (Button) view.findViewById(R.id.btn_save);
        btnSave.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_back:
                    FragmentNavigationManagerController.navigationFragment(getActivity(), new HomeFragment(), getString(R.string.home_fragment));

                    break;
                case R.id.btn_save:
                    if (edName.length() > 0 && edComment.length() > 0) {
                        HomeFragment homeFragment = new HomeFragment();
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("task", new Task(edName.getText().toString(), edComment.getText().toString()));
                        homeFragment.setArguments(bundle);
                        FragmentNavigationManagerController.navigationFragment(getActivity(), homeFragment, getString(R.string.home_fragment));
                    } else
                        Toast.makeText(getActivity(), getString(R.string.toast_please_fill), Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    @Override
    public void onActivityBaskPressed() {
        if (isVisible())
            FragmentNavigationManagerController.navigationFragment(getActivity(), new HomeFragment(), getString(R.string.home_fragment));
    }
}
