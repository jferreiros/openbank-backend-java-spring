package openbank.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

@EntityScan
@Entity(name="Manager")
@Table(name = "manager")
@Proxy(lazy = false)
public class Manager {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")	
    private int id;
    @Column(name = "user")
    private String user;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;    

    // @OneToMany(targetEntity = Client.class, mappedBy = "manager", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @JsonIgnore
    // private List<Client> clients = new ArrayList<Client>();

    public Manager() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // public void addClient(Client client) {
    //     clients.add(client);
    //     client.setManager(this);
    // }

    // public List<Client> getClients() {
    //   return clients;
    // }


    // public void setClients(ArrayList<Client> clients) {
    //   this.clients = clients;
    //   for (int i = 0; i < clients.size(); i++) {
    //       clients.get(i).setManager(this);
    //   }
    // }

    @Override
    public String toString() {
        return user;
    }

}