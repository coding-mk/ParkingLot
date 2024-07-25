package org.example.ParkingLot.Controllers;

import org.example.ParkingLot.Dtos.IssueTicketRequestDto;
import org.example.ParkingLot.Service.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketRequestDto issueTicket(IssueTicketRequestDto requestDto){
        return null;
    }
}
