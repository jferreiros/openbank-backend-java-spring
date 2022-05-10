package openbank.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan
@Entity(name="Client")
// @JsonIgnoreProperties(value= {"suppliers"})
@Table(name = "client")
@Proxy(lazy = false)
public class Client {
    private int id;
    private Manager manager;
    private String user;
    private String password;
    private String email;
    private double balance;

    public Client() {
    }

    public Client(String user, String password, String email) {
        this.user = user;
        this.password = password;
        this.email = email;
    }        

    public Client(Manager manager, String user, String password, String email, double balance) {
        this.manager = manager;
        this.user = user;
        this.password = password;
        this.email = email;
        this.balance = balance;
    }

    public Client(int id, Manager manager, String user, String password, String email, double balance) {
        this.id = id;
        this.manager = manager;
        this.user = user;
        this.password = password;
        this.email = email;
        this.balance = balance;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_manager", nullable = false)
    @JsonIgnore
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Column(name = "user")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "balance")
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
