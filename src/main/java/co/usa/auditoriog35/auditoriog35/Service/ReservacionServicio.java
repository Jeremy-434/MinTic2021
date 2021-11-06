package co.usa.auditoriog35.auditoriog35.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.auditoriog35.auditoriog35.Model.Reservacion;
import co.usa.auditoriog35.auditoriog35.Repository.ContadorClientes;
import co.usa.auditoriog35.auditoriog35.Repository.ReservacionRepositorio;
import co.usa.auditoriog35.auditoriog35.Repository.StatusReservas;

@Service
public class ReservacionServicio {
    @Autowired
    ReservacionRepositorio reservacionRepositorio;
    // @Autowired
    // ReservacionCrudRepositorio reservacionCrudRepositorio;

    public List<Reservacion>mostrarTodo(){
        return reservacionRepositorio.mostarTodo();
    }

    public Optional<Reservacion>mostarUno(int id){
        return reservacionRepositorio.mostrarUno(id);
    }

    public Reservacion guardar(Reservacion reservacion){
        if (reservacion.getIdReservation()==null) {
            return reservacionRepositorio.guardar(reservacion);
        } else {
            Optional<Reservacion> e=reservacionRepositorio.mostrarUno(reservacion.getIdReservation());
            if (e.isEmpty()) {
                return reservacionRepositorio.guardar(reservacion);
            } else {
                return reservacion;
            }
        }
    }

    public Reservacion actualizar(Reservacion reservacion){
        if (reservacion.getIdReservation()!=null) {
            Optional<Reservacion> e=reservacionRepositorio.mostrarUno(reservacion.getIdReservation());
            if (!e.isEmpty()) {
                if(reservacion.getStartDate()!=null){
                    e.get().setStartDate(reservacion.getStartDate());
                }
                if(reservacion.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservacion.getDevolutionDate());
                }
                if(reservacion.getStatus()!=null){
                    e.get().setStatus(reservacion.getStatus());
                }

                reservacionRepositorio.guardar(e.get());
                return e.get();
            } else {
                return reservacion;
            }
            
        } else {
            return reservacion;
        }
    }

    public boolean borrar(int id){
        Boolean aBoolean = mostarUno(id).map(mensaje -> {
            reservacionRepositorio.borrar(mensaje);
            return true;
        }).orElse(false);
        return aBoolean;
    }


    public StatusReservas getReservationsStatusReport(){
        List<Reservacion>completed=reservacionRepositorio.getReservationByStatus("completed");
        List<Reservacion>cancelled=reservacionRepositorio.getReservationByStatus("cancelled");
    return new StatusReservas(completed.size(), cancelled.size());
    }

    public List<Reservacion> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date aDate= new Date();
        Date bDate= new Date();
        
       try {
           aDate = parser.parse(dateA);
           bDate = parser.parse(dateB);
       }catch(ParseException evt){
           evt.printStackTrace();
       }
       if(aDate.before(bDate)){
           return reservacionRepositorio.getReservationPeriod(aDate, bDate);
       }else{
           return new ArrayList<>();
       } 

     }

    public List<ContadorClientes> getTopClients(){
              return reservacionRepositorio.getTopClients();
        }
}
