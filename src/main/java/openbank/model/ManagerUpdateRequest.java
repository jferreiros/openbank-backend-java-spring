package openbank.model;

import java.util.ArrayList;

public class ManagerUpdateRequest {
    private Manager manager;
    private ArrayList<Client> clients;
    
    public ManagerUpdateRequest() {}

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    
}
