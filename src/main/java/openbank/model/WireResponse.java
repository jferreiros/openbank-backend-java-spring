package openbank.model;

import java.util.ArrayList;

public class WireResponse {
    private Wire wire;
    private ArrayList<Wire> wires;
    private Exception error;
    
    public WireResponse() {
    }
    public WireResponse(Wire wire) {
        this.wire = wire;
    }
    public WireResponse(ArrayList<Wire> wires) {
        this.wires = wires;
    }
    public WireResponse(Exception error) {
        this.error = error;
    }
    public Wire getWire() {
        return wire;
    }
    public void setWire(Wire wire) {
        this.wire = wire;
    }
    public ArrayList<Wire> getWires() {
        return wires;
    }
    public void setWires(ArrayList<Wire> wires) {
        this.wires = wires;
    }
    public Exception getError() {
        return error;
    }
    public void setError(Exception error) {
        this.error = error;
    }

    
    
}
