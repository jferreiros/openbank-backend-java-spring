package com.openbank.openbank.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Table(name = "prestamo")
public class Loan {
    private int id;
    private String nombre;
    private Number comision;
    private int meses;

    public Loan() {
    }

    public Loan(String nombre, Number comision, int meses) {
        this.nombre = nombre;
        this.comision = comision;
        this.meses = meses;
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
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Column(name = "comision")
    public Number getComision() {
        return comision;
    }
    public void setComision(Number comision) {
        this.comision = comision;
    }
    @Column(name = "meses")
    public int getMeses() {
        return meses;
    }
    public void setMeses(int meses) {
        this.meses = meses;
    } 

    
}
