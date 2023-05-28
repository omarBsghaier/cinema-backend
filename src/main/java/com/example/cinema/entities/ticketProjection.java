package com.example.cinema.entities;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ticketProj", types = Ticket.class)
public interface ticketProjection {
    public Long getId() ;
    public String getNomClient() ;
    public double getPrix();
    public Integer getCodePayment() ;
    public boolean getReserve() ;
    public Place getPlace() ;

}
