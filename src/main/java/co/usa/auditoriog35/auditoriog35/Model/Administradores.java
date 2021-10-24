package co.usa.auditoriog35.auditoriog35.Model;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Administradores {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idUser;
    private String email;
    private String password;
    private String name;
    public Integer getIdUser() {
        return idUser;
    }
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
}
