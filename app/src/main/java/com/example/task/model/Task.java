package com.example.task.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Misha Dichuk on 28.05.16.
 */
public class Task implements Parcelable {
    private String name;
    private String comment;

    public Task() {

    }

    public Task(String name, String comment) {
        setName(name);
        setComment(comment);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    protected Task(Parcel in) {
        name = in.readString();
        comment = in.readString();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(comment);
    }
}
