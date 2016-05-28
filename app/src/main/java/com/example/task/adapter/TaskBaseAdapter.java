package com.example.task.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.task.R;
import com.example.task.model.Task;

import java.util.List;

/**
 * Created by Misha Dichuk on 28.05.16.
 */
public class TaskBaseAdapter extends BaseAdapter {

    private class ViewHolder {
        TextView txtName, txtComment;

        private ViewHolder(View view) {
            txtName = (TextView) view.findViewById(R.id.txt_name);
            txtComment = (TextView) view.findViewById(R.id.txt_comment);
        }
    }

    private List<Task> tasks;
    private LayoutInflater inflater;

    public TaskBaseAdapter(Context context, List<Task> tasks) {
        this.tasks = tasks;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public void setList(Task task) {
        tasks.add(task);
    }


    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Task getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (null == view) {
            view = inflater.inflate(R.layout.task_base_adapter, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else
            holder = (ViewHolder) view.getTag();


        Task task = getItem(position);
        if (null != task) {
            holder.txtName.setText(task.getName());
            holder.txtComment.setText(task.getComment());
        }
        return view;
    }
}
