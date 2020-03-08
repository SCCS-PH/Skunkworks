package com.hccs.skunkworks.model;

/**
 *
 * @author DCSalenga
 */
public class TaskBean {

    private String taskName;
    private int taskValue;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskValue() {
        return taskValue;
    }

    public void setTaskValue(int taskValue) {
        this.taskValue = taskValue;
    }

    @Override
    public String toString() {
        return taskName;
    }

}
