package openbank.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import openbank.database.WireManager;
import openbank.model.Wire;
import openbank.model.WireResponse;

@CrossOrigin(origins = "*")
@RestController
public class WireController {
    static WireManager wireManager;

    public WireController() {
        wireManager = new WireManager();
    }

    @GetMapping("/wires")
    public List<Wire> getWires() {
        System.out.println("/managers");
        try {
            return wireManager.read();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/wires/{id}")
    public Wire getWireById(@PathVariable int id) {
        try {
            return wireManager.read(id);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/wires")
    public WireResponse postWire(@RequestBody Wire wire) {
        try {
            return new WireResponse(wireManager.create(wire));
        } catch (Exception exception) {
            return new WireResponse(exception);
        }
    }

    @PutMapping("/wires")
    public WireResponse putWire(@RequestBody Wire wire) {
        try {
            return new WireResponse(wireManager.update(wire));
        } catch (Exception exception) {
            return new WireResponse(exception);
        }
    }

    @DeleteMapping("/wires")
    public WireResponse deleteWire(@RequestBody Wire wire) {
        try {
            return new WireResponse(wireManager.delete(wire));
        } catch (Exception exception) {
            return new WireResponse(exception);
        }
    }
}
