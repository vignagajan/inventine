package com.inventine.model;

public class Employee extends User {

    private int nWorkHours;
    private int nTasks;

    public int getNWorkHours() {
        return nWorkHours;
    }

    public void setNWorkHours(int nWorkHours) {
        this.nWorkHours = nWorkHours;
    }

    public int getNTasks() {
        return nTasks;
    }

    public void setNTasks(int nTasks) {
        this.nTasks = nTasks;
    }
}
