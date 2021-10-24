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

import co.usa.auditoriog35.auditoriog35.Model.Calificacion;
import co.usa.auditoriog35.auditoriog35.Service.CalificacionServicio;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CalificacionControlador {
    @Autowired
    CalificacionServicio calificacionServicio;

    @GetMapping("/all")
    public List<Calificacion>mostrarCalificaciones(){
        return calificacionServicio.mostrarTodo();
    }

    @GetMapping("/{id}")
    public Optional<Calificacion>mostarCalificacion(@PathVariable("id") int calificacionId){
        return calificacionServicio.mostarUno(calificacionId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Calificacion guardarCalificacion(@RequestBody Calificacion calificacion){
        return calificacionServicio.guardar(calificacion);
    }
    
}
