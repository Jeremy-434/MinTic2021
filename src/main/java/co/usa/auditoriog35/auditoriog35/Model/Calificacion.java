package co.usa.auditoriog35.auditoriog35.Model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "score")
public class Calificacion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;
    private Integer qualification;
    private Integer price;
    public Integer getIdScore() {
        return idScore;
    }
    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }
    public Integer getQualification() {
        return qualification;
    }
    public void setQualification(Integer qualification) {
        this.qualification = qualification;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    
    
}
