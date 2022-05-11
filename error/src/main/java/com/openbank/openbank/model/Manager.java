package com.openbank.openbank.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.GenericGenerator;

@EntityScan
@Table(name = "gestor")
public class Manager {
    private int id;
    private String usuario;
    private String password;
    private String correo;    
    @OneToMany(targetEntity = Client.class, mappedBy = "gestor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Client> clients = new ArrayList<Client>();

    public Manager() {}

    @Id
    @Column(name = "id")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "correo")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void addCliente(Client client) {
        clients.add(client);
        client.setManager(this);
    }

    public List<Client> getClients() {
      return clients;
    }


    public void setClientes(ArrayList<Client> clients) {
      this.clients = clients;
      for (int i = 0; i < clients.size(); i++) {
          clients.get(i).setManager(this);
      }
    }

}