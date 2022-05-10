package openbank.model;

import java.util.ArrayList;

public class ClientResponse {
    private Client client;
    private ArrayList<Client> list;
    private Exception error;

    public ClientResponse() {
    }
    public ClientResponse(Client client) {
        this.client = client;
    }
    public ClientResponse(ArrayList<Client> list) {
        this.list = list;
    }
    public ClientResponse(Exception error) {
        this.error = error;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public ArrayList<Client> getList() {
        return list;
    }
    public void setList(ArrayList<Client> list) {
        this.list = list;
    }
    public Exception getError() {
        return error;
    }
    public void setError(Exception error) {
        this.error = error;
    } 
    
}
