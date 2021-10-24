package co.usa.auditoriog35.auditoriog35.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Permite trabajar tablas con bases de datos desde Spring Boot
 */
@Entity
/**
 * Para especificar que es una tabla y el nombre de la misma
 */
@Table(name = "audience")
/**
 * Clase Auditorio en la cual se crean los campos de la tabla con sus respectivas relaciones
 * y sus metodos get y set
 */
public class Auditorio implements Serializable{
    /**
     * se utiliza para especificar que es una llave primaria
     */
    @Id
    /**
     * Permite que el valor de la llave primaria sea autoincrementable
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /**
     * Llave primaria de tipo entero
     */
    private Integer id;
    /**
     * Campo nombre de tipo cadena
     */
    private String name;
    /**
     * Campo propietario de tipo cadena
     */
    private String owner;
    /**
     * Campo capacidad de tipo entero
     */
    private Integer capacity;
    /**
     * Campo descripcion de tipo cadena
     */
    private String description;

    /**
     * relacion de muchos a uno
     */
    @ManyToOne
    /**
     * indica el nombre de la columna y tabla con la que se va a realizar la relacion
     */
    @JoinColumn(name = "categoryId")
    /**
     * Se indica que ignore el campo audiences de la tabla category para no entrar en un bucle
     */
    @JsonIgnoreProperties("audiences")
    /**
     * Campo categoria que realiza una instancia a la clase Categoria model
     */
    private Categoria category;

    /**
     * relacion de uno a muchos 
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "audience")
    /**
     * Se indica que ignore los campos audience y client de la tabla message
     * para no entrar en un bucle
     */
    @JsonIgnoreProperties({"audience","client"})
    /**
     * Campo mensaje que realiza una instancia a la clase Mensaje model
     */
    private List<Mensaje> messages;

    /**
     * relacion de uno a muchos 
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "audience")
    /**
     * Se indica que ignore los campos audience y client de la tabla reservation
     * para no entrar en un bucle
     */
    @JsonIgnoreProperties({"audience","client"})
    /**
     * Campo reservacion que realiza una instancia a la clase Reservacion model
     */
    private List<Reservacion> reservations;

    /**
     * Metodo que permite obtener el id de la tabla audience
     * @return dato de tipo entero
     */
    public Integer getId() {
        return id;
    }

    /**
     * Metodo que permite asignar el id de la tabla audience
     * @param id de tipo entero
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Metodo que permite obtener el valor del campo nombre de la tabla audience
     * @return dato de tipo cadena
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que permite asignar el valor del campo nombre, de la tabla audience
     * @param name dato de tipo cadena
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo que permite obtener el valor del campo propietario, de la tabla audience
     * @return dato de tipo cadena
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Metodo que permite asignar el valor del campo propietario, de la tabla audience
     * @param owner dato de tipo cadena
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Metodo que permite obtener el valor del campo capacidad, de la tabla audience
     * @return dato de tipo entero
     */
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * Metodo que permite asignar el valor del campo capacidad, de la tabla audience
     * @param capacity dato de tipo entero
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * Metodo que permite obtener el valor del campo descripcion, de la tabla audience
     * @return dato de tipo cadena
     */
    public String getDescription() {
        return description;
    }

    /**
     * Metodo que permite asignar el valor del campo descrpcion, de la tabla audience
     * @param description dato de tipo cadena
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Metodo que permite obtener el valor del campo categoria, de la tabla audience
     * @return objeto de tipo Category
     */
    public Categoria getCategory() {
        return category;
    }

    /**
     * Metodo que permite asignar el valor del campo categoria, de la tabla audience
     * @param category objeto de tipo Category
     */
    public void setCategory(Categoria category) {
        this.category = category;
    }

    /**
     * Metodo que permite obtener el valor del campo mensaje, de la tabla audience
     * @return objeto de tipo message
     */
    public List<Mensaje> getMessages() {
        return messages;
    }

    /**
     * Metodo que permite asignar el valor del campo mensajes, de la tabla audience
     * @param messages objeto de tipo message
     */
    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    /**
     * Metodo que permite obtener el valor del campo reservacion, de la tabla audience
     * @return objeto de tipo reservation
     */
    public List<Reservacion> getReservations() {
        return reservations;
    }

    /**
     * Metodo que permite asignar el valor del campo reservacion, de la tabla audience
     * @param reservations objeto de tipo reservation
     */
    public void setReservations(List<Reservacion> reservations) {
        this.reservations = reservations;
    }

    
}
