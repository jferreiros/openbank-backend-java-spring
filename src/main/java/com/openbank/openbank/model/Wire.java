package com.openbank.openbank.model;

import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Table(name = "transferencia")
public class Wire {
    private int id;
    private int id_ordenante;
    private int id_beneficiario;
    private Number importe;
    private String concepto;
    private Timestamp fecha;

    public Wire() {
    }

    public Wire(int id_ordenante, int id_beneficiario, Number importe, String concepto, Timestamp fecha) {
        this.id_ordenante = id_ordenante;
        this.id_beneficiario = id_beneficiario;
        this.importe = importe;
        this.concepto = concepto;
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
    @Column(name = "id_ordenante")
    public int getId_ordenante() {
        return id_ordenante;
    }
    public void setId_ordenante(int id_ordenante) {
        this.id_ordenante = id_ordenante;
    }
    @Column(name = "id_beneficiario")
    public int getId_beneficiario() {
        return id_beneficiario;
    }
    public void setId_beneficiario(int id_beneficiario) {
        this.id_beneficiario = id_beneficiario;
    }
    @Column(name = "importe")
    public Number getImporte() {
        return importe;
    }
    public void setImporte(Number importe) {
        this.importe = importe;
    }
    @Column(name = "concepto")
    public String getConcepto() {
        return concepto;
    }
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    @Column(name = "fecha")
    public Timestamp getFecha() {
        return fecha;
    }
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    
}
