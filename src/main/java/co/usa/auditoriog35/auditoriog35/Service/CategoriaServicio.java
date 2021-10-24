package co.usa.auditoriog35.auditoriog35.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.auditoriog35.auditoriog35.Model.Categoria;
import co.usa.auditoriog35.auditoriog35.Repository.CategoriaRepositorio;

@Service
public class CategoriaServicio {
    @Autowired
    CategoriaRepositorio categoriaRepositorio;

    public List<Categoria>mostrarTodo(){
        return categoriaRepositorio.mostarTodo();
    }

    public Optional<Categoria>mostarUno(int id){
        return categoriaRepositorio.mostrarUno(id);
    }


    public Categoria guardar(Categoria guardarCategoria){
        if (guardarCategoria.getId()==null) {
            return categoriaRepositorio.guardar(guardarCategoria);
        } else {
            Optional<Categoria> consulta=categoriaRepositorio.mostrarUno(guardarCategoria.getId());
            if (consulta.isEmpty()) {
                return categoriaRepositorio.guardar(guardarCategoria);
            } else {
                return guardarCategoria;
            }
        }
    }

    public Categoria actualizar(Categoria categoria){
        if (categoria.getId()!=null) {
            Optional<Categoria> e=categoriaRepositorio.mostrarUno(categoria.getId());
            if (!e.isEmpty()) {
                if(categoria.getName()!=null){
                    e.get().setName(categoria.getName());
                }
                if (categoria.getDescription()!=null) {
                    e.get().setDescription(categoria.getDescription());
                }
                categoriaRepositorio.guardar(e.get());
                return e.get();
            } else {
                return categoria;
            }
            
        } else {
            return categoria;
        }
    }

    public boolean borrar(int id){
        Boolean aBoolean = mostarUno(id).map(categoria -> {
            categoriaRepositorio.borrar(categoria);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
