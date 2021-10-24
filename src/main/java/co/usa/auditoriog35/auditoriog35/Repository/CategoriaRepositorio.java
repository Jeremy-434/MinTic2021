package co.usa.auditoriog35.auditoriog35.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.auditoriog35.auditoriog35.Model.Categoria;
import co.usa.auditoriog35.auditoriog35.Repository.Crud.CategoriaCrudRepositorio;

@Repository
public class CategoriaRepositorio {
    @Autowired
    CategoriaCrudRepositorio categoriaCrudRepositorio;

    public List<Categoria> mostarTodo(){
        return(List<Categoria>) categoriaCrudRepositorio.findAll();
    }

    public Optional<Categoria> mostrarUno(int id){
        return categoriaCrudRepositorio.findById(id);
    }

    public Categoria guardar(Categoria guardarCategoria){
        return categoriaCrudRepositorio.save(guardarCategoria);
    }

    public void borrar(Categoria borrarCategoria){
        categoriaCrudRepositorio.delete(borrarCategoria);
    }
}
