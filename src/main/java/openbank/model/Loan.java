package openbank.model;

import java.math.BigDecimal;

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
    private BigDecimal comission;
    private int month;

    public Loan() {
    }

    public Loan(String name, BigDecimal comission, int month) {
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
    @Column(name = "name")
    public String getNombre() {
        return name;
    }
    public void setNombre(String name) {
        this.name = name;
    }
    @Column(name = "comission")
    public BigDecimal getComision() {
        return comission;
    }
    public void setComision(BigDecimal comission) {
        this.comission = comission;
    }
    @Column(name = "month")
    public int getMeses() {
        return month;
    }
    public void setMeses(int month) {
        this.month = month;
    } 

    
}
