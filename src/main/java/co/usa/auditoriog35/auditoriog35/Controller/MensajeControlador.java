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

import co.usa.auditoriog35.auditoriog35.Model.Mensaje;
import co.usa.auditoriog35.auditoriog35.Service.MensajeServicio;


@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MensajeControlador {
    @Autowired
    MensajeServicio mensajeServicio;

    @GetMapping("/all")
    public List<Mensaje>mostrarMensajes(){
        return mensajeServicio.mostrarTodo();
    }

    @GetMapping("/{id}")
    public Optional<Mensaje>mostarMensaje(@PathVariable("id") int mensajeId){
        return mensajeServicio.mostarUno(mensajeId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje guardarMensaje(@RequestBody Mensaje mensaje){
        return mensajeServicio.guardar(mensaje);
    }

}
