package co.usa.auditoriog35.auditoriog35.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.auditoriog35.auditoriog35.Model.Calificacion;
import co.usa.auditoriog35.auditoriog35.Repository.CalificacionRepositorio;

@Service
public class CalificacionServicio {
    @Autowired
    CalificacionRepositorio calificacionRepositorio;

    public List<Calificacion>mostrarTodo(){
        return calificacionRepositorio.mostarTodo();
    }

    public Optional<Calificacion>mostarUno(int id){
        return calificacionRepositorio.mostrarUno(id);
    }

    public Calificacion guardar(Calificacion calificacion){
        if (calificacion.getIdScore()==null) {
            return calificacionRepositorio.guardar(calificacion);
        } else {
            Optional<Calificacion> e=calificacionRepositorio.mostrarUno(calificacion.getIdScore());
            if (e.isEmpty()) {
                return calificacionRepositorio.guardar(calificacion);
            } else {
                return calificacion;
            }
        }
    }

    public Calificacion actualizar(Calificacion calificacion){
        if (calificacion.getIdScore()!=null) {
            Optional<Calificacion> e=calificacionRepositorio.mostrarUno(calificacion.getIdScore());
            if (!e.isEmpty()) {
                if(calificacion.getQualification()!=null){
                    e.get().setQualification(calificacion.getQualification());
                }
                if(calificacion.getPrice()!=null){
                    e.get().setPrice(calificacion.getPrice());
                }
                calificacionRepositorio.guardar(e.get());
                return e.get();
            } else {
                return calificacion;
            }
            
        } else {
            return calificacion;
        }
    }

    public boolean borrar(int id){
        Boolean aBoolean = mostarUno(id).map(calificacion -> {
            calificacionRepositorio.borrar(calificacion);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
