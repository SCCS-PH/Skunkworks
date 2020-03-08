package com.hccs.skunkworks.model;

/**
 *
 * @author DCSalenga
 */
public class TaskBean {

    private String taskName;
    private int taskValue;
    private boolean active;

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
