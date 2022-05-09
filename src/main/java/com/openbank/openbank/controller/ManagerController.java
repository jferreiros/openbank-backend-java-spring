package com.openbank.openbank.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import com.openbank.openbank.database.ManagerManager;
import com.openbank.openbank.model.Manager;
import com.openbank.openbank.model.Client;
import com.openbank.openbank.model.ManagerResponse;
import com.openbank.openbank.model.ManagerUpdateRequest;

@CrossOrigin(origins = "*")
@RestController
public class ManagerController {

    static ManagerManager managerManager;

    public ManagerController() {
        managerManager = new ManagerManager();
    }

    @GetMapping("/managers")
    public List<Manager> getGestores() {
        try {
            return managerManager.read();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/managers/{id}")
    public Manager getGestoresById(@PathVariable int id) {
        try {
            return managerManager.read(id);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/managers")
    public ManagerResponse postGestores(@RequestBody Manager manager) {
        try {
            return new ManagerResponse(managerManager.create(manager));
        } catch (Exception exception) {
            return new ManagerResponse(exception);
        }
    }

    @PutMapping("/managers")
    public ManagerResponse putGestores(@RequestBody ManagerUpdateRequest managerRequest) {
        try {
            Manager manager = managerRequest.getGestor();
            manager.setClientes(managerRequest.getClientes());
            return new ManagerResponse(managerManager.update(manager));
        } catch (Exception exception) {
            return new ManagerResponse(exception);
        }
    }

}
