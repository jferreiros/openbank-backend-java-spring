package com.openbank.openbank.model;

import java.util.ArrayList;


public class ManagerResponse {
    private Manager manager;
    private ArrayList<Manager> list;
    private Exception error;

    public ManagerResponse() {
    }
    public ManagerResponse(Manager manager) {
        this.manager = manager;
    }
    public ManagerResponse(ArrayList<Manager> list) {
        this.list = list;
    }
    public ManagerResponse(Exception error) {
        this.error = error;
    }
    public Manager getManager() {
        return manager;
    }
    public void setManager(Manager manager) {
        this.manager = manager;
    }
    public ArrayList<Manager> getList() {
        return list;
    }
    public void setList(ArrayList<Manager> list) {
        this.list = list;
    }
    public Exception getError() {
        return error;
    }
    public void setError(Exception error) {
        this.error = error;
    } 
     
    
}
