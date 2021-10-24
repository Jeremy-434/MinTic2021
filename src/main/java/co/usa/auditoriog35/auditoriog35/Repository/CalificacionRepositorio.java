package co.usa.auditoriog35.auditoriog35.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.auditoriog35.auditoriog35.Model.Calificacion;
import co.usa.auditoriog35.auditoriog35.Repository.Crud.CalificacionCrudRepositorio;

@Repository
public class CalificacionRepositorio {
    @Autowired
    CalificacionCrudRepositorio calificacionCrudRepositorio;

    public List<Calificacion> mostarTodo(){
        return(List<Calificacion>) calificacionCrudRepositorio.findAll();
    }

    public Optional<Calificacion> mostrarUno(int id){
        return calificacionCrudRepositorio.findById(id);
    }

    public Calificacion guardar(Calificacion guardarCalificacion){
        return calificacionCrudRepositorio.save(guardarCalificacion);
    }

    public void borrar(Calificacion borrarCalificacion){
        calificacionCrudRepositorio.delete(borrarCalificacion);
    }
}
