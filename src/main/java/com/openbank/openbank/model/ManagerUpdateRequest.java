package com.openbank.openbank.model;

import java.util.ArrayList;

public class ManagerUpdateRequest {
    private Manager manager;
    private ArrayList<Client> clients;
    
    public ManagerUpdateRequest() {}

    public Manager getGestor() {
        return manager;
    }

    public void setGestor(Manager manager) {
        this.manager = manager;
    }

    public ArrayList<Client> getClientes() {
        return clients;
    }

    public void setClientes(ArrayList<Client> clients) {
        this.clients = clients;
    }

    
}
