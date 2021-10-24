package co.usa.auditoriog35.auditoriog35.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.auditoriog35.auditoriog35.Model.Auditorio;
import co.usa.auditoriog35.auditoriog35.Repository.AuditorioRepositorio;

@Service
public class AuditorioServicio {
    @Autowired
    AuditorioRepositorio auditorioRepositorio;

    public List<Auditorio>mostrarTodo(){
        return auditorioRepositorio.mostarTodo();
    }

    public Optional<Auditorio>mostarUno(int id){
        return auditorioRepositorio.mostrarUno(id);
    }

    public Auditorio guardar(Auditorio auditorio){
        if (auditorio.getId()==null) {
            return auditorioRepositorio.guardar(auditorio);
        } else {
            Optional<Auditorio> e=auditorioRepositorio.mostrarUno(auditorio.getId());
            if (e.isEmpty()) {
                return auditorioRepositorio.guardar(auditorio);
            } else {
                return auditorio;
            }
        }
    }

    public Auditorio actualizar(Auditorio auditorio){
        if (auditorio.getId()!=null) {
            Optional<Auditorio> e=auditorioRepositorio.mostrarUno(auditorio.getId());
            if (!e.isEmpty()) {
                if(auditorio.getName()!=null){
                    e.get().setName(auditorio.getName());
                }
                if (auditorio.getOwner()!=null) {
                    e.get().setOwner(auditorio.getOwner());
                }
                if (auditorio.getCapacity()!=null) {
                    e.get().setCapacity(auditorio.getCapacity());
                }
                if (auditorio.getDescription()!=null) {
                    e.get().setDescription(auditorio.getDescription());
                }
                if (auditorio.getCategory()!=null) {
                    e.get().setCategory(auditorio.getCategory());
                }
                auditorioRepositorio.guardar(e.get());
                return e.get();
            } else {
                return auditorio;
            }
            
        } else {
            return auditorio;
        }
    }

    public boolean borrar(int id){
        Boolean aBoolean = mostarUno(id).map(auditorio -> {
            auditorioRepositorio.borrar(auditorio);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
