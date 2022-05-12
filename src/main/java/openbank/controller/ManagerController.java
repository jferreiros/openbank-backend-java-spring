package openbank.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import openbank.database.ManagerManager;
import openbank.model.Manager;
import openbank.model.ManagerResponse;
// import openbank.model.ManagerUpdateRequest;

@CrossOrigin(origins = "*")
@RestController
public class ManagerController {

    static ManagerManager managerManager;

    public ManagerController() {
        managerManager = new ManagerManager();
    }

    @GetMapping("/managers")
    public List<Manager> getManagers() {
        System.out.println("/managers");
        try {
            return managerManager.read();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/managers/{id}")
    public Manager getManagersById(@PathVariable int id) {
        try {
            return managerManager.read(id);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/managers")
    public ManagerResponse postManagers(@RequestBody Manager manager) {
        try {
            return new ManagerResponse(managerManager.create(manager));
        } catch (Exception exception) {
            return new ManagerResponse(exception);
        }
    }

    @PutMapping("/managers")
    public ManagerResponse putGestores(@RequestBody Manager manager) {
        try {
            return new ManagerResponse(managerManager.update(manager));
        } catch (Exception exception) {
            return new ManagerResponse(exception);
        }
    }

    @DeleteMapping("/managers")
    public ManagerResponse deleteGestores(@RequestBody Manager manager) {
        try {
            return new ManagerResponse(managerManager.delete(manager));
        } catch (Exception exception) {
            return new ManagerResponse(exception);
        }
    }

    // @PutMapping("/managers")
    // public ManagerResponse putGestores(@RequestBody ManagerUpdateRequest managerRequest) {
    //     try {
    //         Manager manager = managerRequest.getManager();
    //         manager.setClients(managerRequest.getClients());
    //         return new ManagerResponse(managerManager.update(manager));
    //     } catch (Exception exception) {
    //         return new ManagerResponse(exception);
    //     }
    // }

}
