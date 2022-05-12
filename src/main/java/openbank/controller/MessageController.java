package openbank.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import openbank.database.MessageManager;
import openbank.model.Message;
import openbank.model.MessageResponse;

@CrossOrigin(origins = "*")
@RestController
public class MessageController {
    static MessageManager messageManager;

    public MessageController() {
        messageManager = new MessageManager();
    }

    @GetMapping("/messages")
    public List<Message> getMessages() {
        System.out.println("/messages");
        try {
            return messageManager.read();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/messages/{id}")
    public Message getMessageById(@PathVariable int id) {
        try {
            return messageManager.read(id);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/messages")
    public MessageResponse postMessage(@RequestBody Message message) {
        try {
            return new MessageResponse(messageManager.create(message));
        } catch (Exception exception) {
            return new MessageResponse(exception);
        }
    }

    @PutMapping("/messages")
    public MessageResponse putMessage(@RequestBody Message message) {
        try {
            return new MessageResponse(messageManager.update(message));
        } catch (Exception exception) {
            return new MessageResponse(exception);
        }
    }

    @DeleteMapping("/messages")
    public MessageResponse deleteMessage(@RequestBody Message message) {
        try {
            return new MessageResponse(messageManager.delete(message));
        } catch (Exception exception) {
            return new MessageResponse(exception);
        }
    }
}
