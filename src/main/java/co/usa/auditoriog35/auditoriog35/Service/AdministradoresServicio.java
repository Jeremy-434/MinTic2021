package co.usa.auditoriog35.auditoriog35.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.auditoriog35.auditoriog35.Model.Administradores;
import co.usa.auditoriog35.auditoriog35.Repository.AdministradoresRepositorio;

@Service
public class AdministradoresServicio {
    @Autowired
    AdministradoresRepositorio administradoresRepositorio;

    public List<Administradores>mostrarTodo(){
        return administradoresRepositorio.mostarTodo();
    }

    public Optional<Administradores>mostarUno(int id){
        return administradoresRepositorio.mostrarUno(id);
    }

    public Administradores guardar(Administradores administradores){
        if (administradores.getIdUser()==null) {
            return administradoresRepositorio.guardar(administradores);
        } else {
            Optional<Administradores> e=administradoresRepositorio.mostrarUno(administradores.getIdUser());
            if (e.isEmpty()) {
                return administradoresRepositorio.guardar(administradores);
            } else {
                return administradores;
            }
        }
    }

    public Administradores actualizar(Administradores administradores){
        if (administradores.getIdUser()!=null) {
            Optional<Administradores> e=administradoresRepositorio.mostrarUno(administradores.getIdUser());
            if (!e.isEmpty()) {
                if(administradores.getEmail()!=null){
                    e.get().setEmail(administradores.getEmail());
                }
                if(administradores.getPassword()!=null){
                    e.get().setPassword(administradores.getPassword());
                }
                if(administradores.getName()!=null){
                    e.get().setName(administradores.getName());
                }
                administradoresRepositorio.guardar(e.get());
                return e.get();
            } else {
                return administradores;
            }
            
        } else {
            return administradores;
        }
    }

    public boolean borrar(int id){
        Boolean aBoolean = mostarUno(id).map(administradores -> {
            administradoresRepositorio.borrar(administradores);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
