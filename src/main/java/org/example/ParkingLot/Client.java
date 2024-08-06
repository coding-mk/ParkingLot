package org.example.ParkingLot;

import org.example.ParkingLot.Controllers.TicketController;
import org.example.ParkingLot.Dtos.IssueTicketRequestDto;
import org.example.ParkingLot.Dtos.IssueTicketResponseDto;
import org.example.ParkingLot.Models.Ticket;
import org.example.ParkingLot.Models.VehicleType;
import org.example.ParkingLot.Repository.GateRepository;
import org.example.ParkingLot.Repository.ParkingLotRepository;
import org.example.ParkingLot.Repository.TicketRepository;
import org.example.ParkingLot.Repository.VehicleRepository;
import org.example.ParkingLot.Service.TicketService;

public class Client {
    public static void main(String[] args) {
        IssueTicketRequestDto requestDto = new IssueTicketRequestDto();
        requestDto.setGateId(32L);
        requestDto.setVehicleType(VehicleType.SUV);
        requestDto.setVehicleNumber("KA12X6789");
        requestDto.setVehicleOwnerName("Krithi");

        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

        TicketService ticketService = new TicketService(
                gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository
        );

        TicketController ticketController = new TicketController(ticketService);

        IssueTicketResponseDto responseDto = ticketController.issueTicket(requestDto);
        Ticket ticket = responseDto.getTicket();
    }
}
