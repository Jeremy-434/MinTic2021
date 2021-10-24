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

import co.usa.auditoriog35.auditoriog35.Model.Administradores;
import co.usa.auditoriog35.auditoriog35.Service.AdministradoresServicio;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AdministradoresControlador {
    @Autowired
    AdministradoresServicio administradoresServicio;

    @GetMapping("/all")
    public List<Administradores>mostrarAdministradores(){
        return administradoresServicio.mostrarTodo();
    }

    @GetMapping("/{id}")
    public Optional<Administradores>mostarAdministrador(@PathVariable("id") int administradorId){
        return administradoresServicio.mostarUno(administradorId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Administradores guardarAdministrador(@RequestBody Administradores administrador){
        return administradoresServicio.guardar(administrador);
    }
    
}
