package org.example.ParkingLot.Controllers;

import org.example.ParkingLot.Dtos.IssueTicketRequestDto;
import org.example.ParkingLot.Dtos.IssueTicketResponseDto;
import org.example.ParkingLot.Dtos.ResponseStatus;
import org.example.ParkingLot.Exception.GateNotFoundException;
import org.example.ParkingLot.Models.Ticket;
import org.example.ParkingLot.Service.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto requestDto) {
        IssueTicketResponseDto responseDto = new IssueTicketResponseDto();
        try
        {
            Ticket ticket = ticketService.issueTicket(
                    requestDto.getGateId(),
                    requestDto.getVehicleNumber(),
                    requestDto.getVehicleOwnerName(),
                    requestDto.getVehicleType()
            );
            responseDto.setTicket(ticket);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (GateNotFoundException ex)
        {
            ex.getMessage();
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
