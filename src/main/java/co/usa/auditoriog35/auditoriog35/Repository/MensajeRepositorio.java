package co.usa.auditoriog35.auditoriog35.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.auditoriog35.auditoriog35.Model.Mensaje;
import co.usa.auditoriog35.auditoriog35.Repository.Crud.MensajeCrudRepositorio;

@Repository
public class MensajeRepositorio {
    @Autowired
    MensajeCrudRepositorio mensajeCrudRepositorio;

    public List<Mensaje> mostarTodo(){
        return(List<Mensaje>) mensajeCrudRepositorio.findAll();
    }

    public Optional<Mensaje> mostrarUno(int id){
        return mensajeCrudRepositorio.findById(id);
    }

    public Mensaje guardar(Mensaje guardarMensaje){
        return mensajeCrudRepositorio.save(guardarMensaje);
    }

    public void borrar(Mensaje borrarMensaje){
        mensajeCrudRepositorio.delete(borrarMensaje);
    }
}
