package com.example.cinema.web;

import com.example.cinema.repoitory.FilmRepository;
import com.example.cinema.repoitory.TicketRepository;
import com.example.cinema.entities.Film;
import com.example.cinema.entities.Ticket;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CinemaRestController {
    private  final String filePath = "/home/omar/Bureau/springProject/images/cinema/" ;
    @Autowired
    private FilmRepository filmRepository ;
    @Autowired
    private TicketRepository ticketRepository ;
    @GetMapping(path = "/imageFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public  byte[] image(@PathVariable(name ="id") Long id) throws Exception {
        Film f = filmRepository.findById(id).get() ;
        String photoName = f.getPhoto() ;
        File file = new File(filePath+photoName) ;
        Path path = Paths.get(file.toURI()) ;
        return Files.readAllBytes(path) ;
    }
@PostMapping("/payerTickets")
@Transactional
@CrossOrigin("*")
    public List<Ticket> payerTicket(@RequestBody TicketForm ticketForm){
        List<Ticket> listTickets = new ArrayList<>() ;
        ticketForm.getTickets().forEach(idTicket->{
            Ticket ticket = ticketRepository.findById(idTicket).get() ;
            ticket.setNomClient(ticketForm.getNomClient());
            ticket.setReserve(true);
            ticket.setCodePayment(ticketForm.getCodePayment());
            ticketRepository.save(ticket) ;
            listTickets.add(ticket);
        });
        return listTickets;

    }


}
@Data
class TicketForm {
    private  String nomClient ;
    private int codePayment ;
    private  List<Long> tickets = new ArrayList<>() ;

}