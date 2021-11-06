package co.usa.auditoriog35.auditoriog35.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.auditoriog35.auditoriog35.Model.Reservacion;
import co.usa.auditoriog35.auditoriog35.Repository.ContadorClientes;
import co.usa.auditoriog35.auditoriog35.Repository.StatusReservas;
import co.usa.auditoriog35.auditoriog35.Service.ReservacionServicio;


@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservacionControlador {
    @Autowired
    ReservacionServicio reservacionServicio;

    @GetMapping("/all")
    public List<Reservacion>mostrarReservaciones(){
        return reservacionServicio.mostrarTodo();
    }

    @GetMapping("/{id}")
    public Optional<Reservacion>mostarReservacion(@PathVariable("id") int reservacionId){
        return reservacionServicio.mostarUno(reservacionId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion guardarReservacion(@RequestBody Reservacion reservacion){
        return reservacionServicio.guardar(reservacion);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion actualizarReservacion(@RequestBody Reservacion reservacion){
        return reservacionServicio.actualizar(reservacion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrarReservacion(@PathVariable("id") int reservacionId){
        return reservacionServicio.borrar(reservacionId);
    }

    @GetMapping("/report-status")
    public StatusReservas getReservationsStatusReport(){
        return reservacionServicio.getReservationsStatusReport();
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservacion> getReservationsReportDates(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
    return reservacionServicio.getReservationPeriod(dateOne, dateTwo);
    }
    
    @GetMapping("/report-clients")
    public List<ContadorClientes> getReservationsReportsClient(){
        return reservacionServicio.getTopClients();
    }

    
}
