package co.usa.auditoriog35.auditoriog35.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.auditoriog35.auditoriog35.Model.Auditorio;
import co.usa.auditoriog35.auditoriog35.Repository.Crud.AuditorioCrudRepositorio;

@Repository
public class AuditorioRepositorio {
    @Autowired
    AuditorioCrudRepositorio auditorioCrudRepositorio;

    public List<Auditorio> mostarTodo(){
        return(List<Auditorio>) auditorioCrudRepositorio.findAll();
    }

    public Optional<Auditorio> mostrarUno(int id){
        return auditorioCrudRepositorio.findById(id);
    }

    public Auditorio guardar(Auditorio guardarAuditorio){
        return auditorioCrudRepositorio.save(guardarAuditorio);
    }

    public void borrar(Auditorio borrarAuditorio){
        auditorioCrudRepositorio.delete(borrarAuditorio);
    }
}
