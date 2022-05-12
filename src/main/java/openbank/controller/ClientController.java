package openbank.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import openbank.database.ClientManager;
import openbank.model.Client;
import openbank.model.ClientResponse;

@CrossOrigin(origins = "*")
@RestController
public class ClientController {
    
    static ClientManager clientManager;
    

    public ClientController() {
        clientManager = new ClientManager();
    }

    @GetMapping("/clients")
    public List<Client> getClients() {
        System.out.println("/clients");
        try {
            return clientManager.read();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/clients/{id}")
    public ClientResponse getClientsById(@PathVariable Long id) {
        try {
            Client client = clientManager.read(id);
            System.out.println(client);
            if (client == null) {
                return new ClientResponse(new Exception("Client not found"));
            }
            return new ClientResponse(clientManager.read(id));
        } catch (Exception e) {
            return new ClientResponse(e);
        }
    }

    @PostMapping("/clients")
    public ClientResponse postClients(@RequestBody Client client) {
        try {
            return new ClientResponse(clientManager.create(client));
        } catch (Exception exception) {
            return new ClientResponse(exception);
        }
    }

    // @PutMapping("/managers")
    // public ManagerResponse putGestores(@RequestBody ManagerUpdateRequest managerRequest) {
    //     try {
    //         Manager manager = managerRequest.getManager();
    //         manager.setClients(managerRequest.getClients());
    //         return new ManagerResponse(clientManager.update(manager));
    //     } catch (Exception exception) {
    //         return new ManagerResponse(exception);
    //     }
    // }

}
