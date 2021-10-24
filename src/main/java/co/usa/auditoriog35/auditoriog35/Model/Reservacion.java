package co.usa.auditoriog35.auditoriog35.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reservation")
public class Reservacion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status="created";

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("reservations")
    private Auditorio audience;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages","reservations"})
    private Cliente client;

    private String Score;

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Auditorio getAudience() {
        return audience;
    }

    public void setAudience(Auditorio audience) {
        this.audience = audience;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }

    
}
