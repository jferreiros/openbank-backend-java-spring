package com.openbank.openbank.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;

@EntityScan
@Table(name = "mensaje")
public class Message {
    private int id;
    private int id_origen;
    private int id_destino;
    private String texto;
    private Timestamp fecha;

    public Message() {

    }    

    public Message(int id_origen, int id_destino, String texto, Timestamp fecha) {
        this.id_origen = id_origen;
        this.id_destino = id_destino;
        this.texto = texto;
        this.fecha = fecha;
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
        return id_origen;
    }

    public void setId_origen(int id_origen) {
        this.id_origen = id_origen;
    }

    @Column(name = "id_destino")
    public int getId_destino() {
        return id_destino;
    }

    public void setId_destino(int id_destino) {
        this.id_destino = id_destino;
    }

    @Column(name = "texto")
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Column(name = "fecha")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    
}
