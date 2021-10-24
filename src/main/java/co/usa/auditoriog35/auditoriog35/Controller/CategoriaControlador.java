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

import co.usa.auditoriog35.auditoriog35.Model.Categoria;
import co.usa.auditoriog35.auditoriog35.Service.CategoriaServicio;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoriaControlador {
    @Autowired
    CategoriaServicio categoriaServicio;

    @GetMapping("/all")
    public List<Categoria>mostrarCategorias(){
        return categoriaServicio.mostrarTodo();
    }

    @GetMapping("/{id}")
    public Optional<Categoria>mostarCategoria(@PathVariable("id") int categoriaId){
        return categoriaServicio.mostarUno(categoriaId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria guardarCategoria(@RequestBody Categoria categoria){
        return categoriaServicio.guardar(categoria);
    }
    
}
