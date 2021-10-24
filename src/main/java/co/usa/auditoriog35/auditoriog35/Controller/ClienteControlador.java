package co.usa.auditoriog35.auditoriog35.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.auditoriog35.auditoriog35.Model.Cliente;
import co.usa.auditoriog35.auditoriog35.Service.ClienteServicio;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClienteControlador {
    @Autowired
    ClienteServicio clienteServicio;

    @GetMapping("/all")
    public List<Cliente>mostrarClientes(){
        return clienteServicio.mostrarTodo();
    }

    @GetMapping("/{id}")
    public Optional<Cliente>mostarCliente(@PathVariable("id") int clienteId){
        return clienteServicio.mostarUno(clienteId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente guardarCliente(@RequestBody Cliente cliente){
        return clienteServicio.guardar(cliente);
    }

}