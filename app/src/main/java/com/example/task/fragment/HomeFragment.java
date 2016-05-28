package com.example.task.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.task.R;
import com.example.task.adapter.TaskBaseAdapter;
import com.example.task.controller.FragmentNavigationManagerController;
import com.example.task.fragment.core.AbstractOnBackFragment;
import com.example.task.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Misha Dichuk on 28.05.16.
 */
public class HomeFragment extends AbstractOnBackFragment {
    private View view;
    private ListView taskListView;
    private Button btnAddItem;
    private Task task;
    private TaskBaseAdapter taskBaseAdapter;
    private List<Task> temp = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        registrationOnBackPressedListener();
        view = inflater.inflate(R.layout.home_fragment, container, false);
        initializationViewElement();
        updateAdapter();
        if (savedInstanceState != null && savedInstanceState.containsKey("saveTask")) {
            taskBaseAdapter.setList(savedInstanceState.<Task>getParcelable("saveTask"));
            taskBaseAdapter.notifyDataSetChanged();
        } else if (null != getArguments()) {
            task = getArguments().getParcelable("task");
            temp.add(task);
            taskBaseAdapter.notifyDataSetChanged();
        }
        return view;
    }


    /**
     * method for init view xml element
     */
    private void initializationViewElement() {
        taskListView = (ListView) view.findViewById(R.id.task_list_view);
        btnAddItem = (Button) view.findViewById(R.id.btn_add_item);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentNavigationManagerController.navigationFragment(getActivity(), new CreateTaskFragment(), getString(R.string.create_task_fragment));
            }
        });


    }


    /**
     * method for update listView
     */
    private void updateAdapter() {
        taskBaseAdapter = new TaskBaseAdapter(getActivity(), temp);
        taskListView.setAdapter(taskBaseAdapter);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable("saveTask", new Task(task.getName(), task.getComment()));
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onActivityBaskPressed() {
        super.onActivityBaskPressed();


    }
}
