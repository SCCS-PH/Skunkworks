package com.hccs.skunkworks.model;

/**
 *
 * @author DCSalenga
 */
public class DirtyWorkBean {

    private String dWName;
    private int dWValue;

    public String getdWName() {
        return dWName;
    }

    public void setdWName(String dWName) {
        this.dWName = dWName;
    }

    public int getdWValue() {
        return dWValue;
    }

    public void setdWValue(int dWValue) {
        this.dWValue = dWValue;
    }

    @Override
    public String toString() {
        return dWName;
    }

}
