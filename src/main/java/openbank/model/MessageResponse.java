package openbank.model;

import java.util.ArrayList;

public class MessageResponse {
private Message message;
private ArrayList<Wire> messages;
private Exception error;
public MessageResponse() {
}
public MessageResponse(Message message) {
    this.message = message;
}
public MessageResponse(ArrayList<Wire> messages) {
    this.messages = messages;
}
public MessageResponse(Exception error) {
    this.error = error;
}
public Message getMessage() {
    return message;
}
public void setMessage(Message message) {
    this.message = message;
}
public ArrayList<Wire> getMessages() {
    return messages;
}
public void setMessages(ArrayList<Wire> messages) {
    this.messages = messages;
}
public Exception getError() {
    return error;
}
public void setError(Exception error) {
    this.error = error;
}



    
}
