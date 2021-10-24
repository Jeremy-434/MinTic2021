package co.usa.auditoriog35.auditoriog35.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.auditoriog35.auditoriog35.Model.Administradores;
import co.usa.auditoriog35.auditoriog35.Repository.Crud.AdministradoresCrudRepositorio;

@Repository
public class AdministradoresRepositorio {
    @Autowired
    AdministradoresCrudRepositorio administradoresCrudRepositorio;

    public List<Administradores> mostarTodo(){
        return(List<Administradores>) administradoresCrudRepositorio.findAll();
    }

    public Optional<Administradores> mostrarUno(int id){
        return administradoresCrudRepositorio.findById(id);
    }

    public Administradores guardar(Administradores guardarAdministradores){
        return administradoresCrudRepositorio.save(guardarAdministradores);
    }

    public void borrar(Administradores borrarAdministradores){
        administradoresCrudRepositorio.delete(borrarAdministradores);
    }
}
