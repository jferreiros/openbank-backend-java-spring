package openbank.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;

@EntityScan
@Entity(name="Message")
@Table(name = "message")
@Proxy(lazy = false)
public class Message {
    private int id;
    private int id_sender;
    private int id_receiver;
    private String text;
    private Timestamp date;

    public Message() {

    }    

    public Message(int id_sender, int id_receiver, String text, Timestamp date) {
        this.id_sender = id_sender;
        this.id_receiver = id_receiver;
        this.text = text;
        this.date = date;
    }

    public Message(int id_sender, int id_receiver, String text) {
        this.id_sender = id_sender;
        this.id_receiver = id_receiver;
        this.text = text;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "id_origen")
    public int getId_origen() {
        return id_sender;
    }

    public void setId_origen(int id_sender) {
        this.id_sender = id_sender;
    }

    @Column(name = "id_destino")
    public int getId_destino() {
        return id_receiver;
    }

    public void setId_destino(int id_receiver) {
        this.id_receiver = id_receiver;
    }

    @Column(name = "texto")
    public String getTexto() {
        return text;
    }

    public void setTexto(String text) {
        this.text = text;
    }

    @Column(name = "fecha")
    public Timestamp getFecha() {
        return date;
    }

    public void setFecha(Timestamp date) {
        this.date = date;
    }

    
}
