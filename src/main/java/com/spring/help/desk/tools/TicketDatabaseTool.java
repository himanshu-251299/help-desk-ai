package com.spring.help.desk.tools;

import com.spring.help.desk.entity.Ticket;
import com.spring.help.desk.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketDatabaseTool {

    private final TicketService ticketService;

    @Tool(description = "This tool helps to create new ticket in database.")
    public Ticket createTicketTool(@ToolParam(description = "Ticket fields required to create new ticket")
                                       Ticket ticket){
        try {
            return ticketService.createTicket(ticket);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Tool(description = "This tool helps to get ticket by the email")
    public Ticket getTicketByEmailTool(@ToolParam(description = "email whose ticket is required")
                                          String email){
        return ticketService.getTicketByEmail(email);
    }

    @Tool(description = "This tool helps to update ticket")
    public Ticket updateTicketTool(@ToolParam(description = "Update Ticket Details")
                                       Ticket ticket){
        return ticketService.updateTicket(ticket);
    }

    @Tool(description = "This tool helps to get current system time")
    public String getCurrentTime(){
        return String.valueOf(System.currentTimeMillis());
    }
}
