package co.usa.auditoriog35.auditoriog35.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.auditoriog35.auditoriog35.Model.Mensaje;
import co.usa.auditoriog35.auditoriog35.Repository.MensajeRepositorio;

@Service
public class MensajeServicio {
    @Autowired
    MensajeRepositorio mensajeRepositorio;

    public List<Mensaje>mostrarTodo(){
        return mensajeRepositorio.mostarTodo();
    }

    public Optional<Mensaje>mostarUno(int id){
        return mensajeRepositorio.mostrarUno(id);
    }

    public Mensaje guardar(Mensaje mensaje){
        if (mensaje.getIdMessage()==null) {
            return mensajeRepositorio.guardar(mensaje);
        } else {
            Optional<Mensaje> e=mensajeRepositorio.mostrarUno(mensaje.getIdMessage());
            if (e.isEmpty()) {
                return mensajeRepositorio.guardar(mensaje);
            } else {
                return mensaje;
            }
        }
    }

    public Mensaje actualizar(Mensaje mensaje){
        if (mensaje.getIdMessage()!=null) {
            Optional<Mensaje> e=mensajeRepositorio.mostrarUno(mensaje.getIdMessage());
            if (!e.isEmpty()) {
                if(mensaje.getMessageText()!=null){
                    e.get().setMessageText(mensaje.getMessageText());
                }
                mensajeRepositorio.guardar(e.get());
                return e.get();
            } else {
                return mensaje;
            }
            
        } else {
            return mensaje;
        }
    }

    public boolean borrar(int id){
        Boolean aBoolean = mostarUno(id).map(mensaje -> {
            mensajeRepositorio.borrar(mensaje);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
