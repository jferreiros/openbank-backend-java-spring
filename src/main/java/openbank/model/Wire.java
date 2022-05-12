package openbank.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Entity(name="Wire")
@Table(name = "wire")
@Proxy(lazy = false)
public class Wire {
    private int id;
    private int id_sender;
    private int id_receiver;
    private BigDecimal amount;
    private String concept;
    // private Timestamp date;
    private Calendar date;

    public Wire() {
    }

    public Wire(int id_sender, int id_receiver, BigDecimal amount, String concept) {
        this.id_sender = id_sender;
        this.id_receiver = id_receiver;
        this.amount = amount;
        this.concept = concept;
    }

    public Wire(int id_sender, int id_receiver, BigDecimal amount, String concept, Calendar date) {
        this.id_sender = id_sender;
        this.id_receiver = id_receiver;
        this.amount = amount;
        this.concept = concept;
        this.date = date;
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
    @Column(name = "id_sender")
    public int getId_ordenante() {
        return id_sender;
    }
    public void setId_ordenante(int id_sender) {
        this.id_sender = id_sender;
    }
    @Column(name = "id_receiver")
    public int getId_beneficiario() {
        return id_receiver;
    }
    public void setId_beneficiario(int id_receiver) {
        this.id_receiver = id_receiver;
    }
    @Column(name = "amount")
    public BigDecimal getImporte() {
        return amount;
    }
    public void setImporte(BigDecimal amount) {
        this.amount = amount;
    }
    @Column(name = "concept")
    public String getConcepto() {
        return concept;
    }
    public void setConcepto(String concept) {
        this.concept = concept;
    }
    @Column(name = "date", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    // @Column(name = "date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")    
    public Calendar getFecha() {
        return date;
    }
    public void setFecha(Calendar date) {
        this.date = date;
    }

    
}
