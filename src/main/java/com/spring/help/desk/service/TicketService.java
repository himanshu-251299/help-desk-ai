package com.spring.help.desk.service;

import com.spring.help.desk.entity.Ticket;
import com.spring.help.desk.repository.TicketRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class TicketService {

    private TicketRepository ticketRepository;

    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public Ticket getTicket(Long ticketId){
        return ticketRepository.findById(ticketId).orElse(null);
    }

    public Ticket getTicketByEmail(String email){
        return ticketRepository.findByEmail(email).orElse(null);
    }
}
