package openbank.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Entity(name="Loan")
@Table(name = "loan")
@Proxy(lazy = false)
public class Loan {
    private int id;
    private String name;
    private Number comission;
    private int month;

    public Loan() {
    }

    public Loan(String name, Number comission, int month) {
        this.name = name;
        this.comission = comission;
        this.month = month;
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
        return name;
    }
    public void setNombre(String name) {
        this.name = name;
    }
    @Column(name = "comision")
    public Number getComision() {
        return comission;
    }
    public void setComision(Number comission) {
        this.comission = comission;
    }
    @Column(name = "meses")
    public int getMeses() {
        return month;
    }
    public void setMeses(int month) {
        this.month = month;
    } 

    
}
