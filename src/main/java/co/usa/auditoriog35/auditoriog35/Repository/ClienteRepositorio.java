package co.usa.auditoriog35.auditoriog35.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.auditoriog35.auditoriog35.Model.Cliente;
import co.usa.auditoriog35.auditoriog35.Repository.Crud.ClienteCrudRepositorio;

@Repository
public class ClienteRepositorio {
    @Autowired
    ClienteCrudRepositorio clienteCrudRepositorio;

    public List<Cliente> mostarTodo(){
        return(List<Cliente>) clienteCrudRepositorio.findAll();
    }

    public Optional<Cliente> mostrarUno(int id){
        return clienteCrudRepositorio.findById(id);
    }

    public Cliente guardar(Cliente guardarCliente){
        return clienteCrudRepositorio.save(guardarCliente);
    }

    public void borrar(Cliente borrarCliente){
        clienteCrudRepositorio.delete(borrarCliente);
    }
}
