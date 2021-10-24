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

import co.usa.auditoriog35.auditoriog35.Model.Auditorio;
import co.usa.auditoriog35.auditoriog35.Service.AuditorioServicio;

@RestController
@RequestMapping("/api/Audience")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AuditorioControlador {
    @Autowired
    AuditorioServicio auditorioServicio;

    @GetMapping("/all")
    public List<Auditorio>mostrarAuditorios(){
        return auditorioServicio.mostrarTodo();
    }

    @GetMapping("/{id}")
    public Optional<Auditorio>mostarAuditorio(@PathVariable("id") int auditorioId){
        return auditorioServicio.mostarUno(auditorioId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Auditorio guardarAuditorio(@RequestBody Auditorio auditorio){
        return auditorioServicio.guardar(auditorio);
    }
    
}
