package co.usa.auditoriog35.auditoriog35.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.auditoriog35.auditoriog35.Model.Reservacion;
import co.usa.auditoriog35.auditoriog35.Repository.Crud.ReservacionCrudRepositorio;

@Repository
public class ReservacionRepositorio {
    @Autowired
    ReservacionCrudRepositorio reservacionCrudRepositorio;

    public List<Reservacion> mostarTodo(){
        return(List<Reservacion>) reservacionCrudRepositorio.findAll();
    }

    public Optional<Reservacion> mostrarUno(int id){
        return reservacionCrudRepositorio.findById(id);
    }

    public Reservacion guardar(Reservacion guardarReservacion){
        return reservacionCrudRepositorio.save(guardarReservacion);
    }

    public void borrar(Reservacion borrarReservacion){
        reservacionCrudRepositorio.delete(borrarReservacion);
    }
}
