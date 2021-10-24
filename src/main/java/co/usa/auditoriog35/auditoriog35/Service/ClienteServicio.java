package co.usa.auditoriog35.auditoriog35.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.auditoriog35.auditoriog35.Model.Cliente;
import co.usa.auditoriog35.auditoriog35.Repository.ClienteRepositorio;

@Service
public class ClienteServicio {
    @Autowired
    ClienteRepositorio clienteRepositorio;

    public List<Cliente>mostrarTodo(){
        return clienteRepositorio.mostarTodo();
    }

    public Optional<Cliente>mostarUno(int id){
        return clienteRepositorio.mostrarUno(id);
    }

    public Cliente guardar(Cliente cliente){
        if (cliente.getIdClient()==null) {
            return clienteRepositorio.guardar(cliente);
        } else {
            Optional<Cliente> e=clienteRepositorio.mostrarUno(cliente.getIdClient());
            if (e.isEmpty()) {
                return clienteRepositorio.guardar(cliente);
            } else {
                return cliente;
            }
        }
    }

    public Cliente actualizar(Cliente cliente){
        if (cliente.getIdClient()!=null) {
            Optional<Cliente> e=clienteRepositorio.mostrarUno(cliente.getIdClient());
            if (!e.isEmpty()) {
                if(cliente.getEmail()!=null){
                    e.get().setEmail(cliente.getEmail());
                }
                if(cliente.getPassword()!=null){
                    e.get().setPassword(cliente.getPassword());
                }
                if(cliente.getName()!=null){
                    e.get().setName(cliente.getName());
                }
                clienteRepositorio.guardar(e.get());
                return e.get();
            } else {
                return cliente;
            }
            
        } else {
            return cliente;
        }
    }

    public boolean borrar(int id){
        Boolean aBoolean = mostarUno(id).map(cliente -> {
            clienteRepositorio.borrar(cliente);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
