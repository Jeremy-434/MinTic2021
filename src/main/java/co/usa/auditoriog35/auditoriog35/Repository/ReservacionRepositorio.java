package co.usa.auditoriog35.auditoriog35.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.auditoriog35.auditoriog35.Model.Cliente;
import co.usa.auditoriog35.auditoriog35.Model.Reservacion;
import co.usa.auditoriog35.auditoriog35.Repository.Crud.ReservacionCrudRepositorio;

@Repository
public class ReservacionRepositorio {
    @Autowired
    ReservacionCrudRepositorio reservacionCrudRepositorio;

    public List<Reservacion> mostarTodo(){
        return(List<Reservacion>) reservacionCrudRepositorio.findAll();
    }

    public Optional<Reservacion> mostrarUno(int id){
        return reservacionCrudRepositorio.findById(id);
    }

    public Reservacion guardar(Reservacion guardarReservacion){
        return reservacionCrudRepositorio.save(guardarReservacion);
    }

    public void borrar(Reservacion borrarReservacion){
        reservacionCrudRepositorio.delete(borrarReservacion);
    }

    public List<Reservacion> getReservationByStatus(String status){
        return reservacionCrudRepositorio.findAllByStatus(status);
    }
    
   public List<Reservacion> getReservationPeriod(Date a, Date b){
       return reservacionCrudRepositorio.findAllByStartDateAfterAndStartDateBefore(a, b);
   } 
   
   public List<ContadorClientes> getTopClients(){
    List<ContadorClientes> res= new ArrayList<>();
    List<Object[]> report = reservacionCrudRepositorio.countTotalReservationByClient();
    for(int i=0;i<report.size();i++){
        res.add(new ContadorClientes((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
    }
    return res;
}
}
