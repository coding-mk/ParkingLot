package org.example.ParkingLot.Service;

import org.example.ParkingLot.Exception.GateNotFoundException;
import org.example.ParkingLot.Factory.SpotAssignmentStrategyFactory;
import org.example.ParkingLot.Models.*;
import org.example.ParkingLot.Repository.GateRepository;
import org.example.ParkingLot.Repository.ParkingLotRepository;
import org.example.ParkingLot.Repository.TicketRepository;
import org.example.ParkingLot.Repository.VehicleRepository;
import org.example.ParkingLot.Strategies.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }
    public Ticket issueTicket(Long gateId,
                              String vehicleNumber,
                              String vehicleOwnerName,
                              VehicleType vehicleType) throws GateNotFoundException {
        Ticket ticket = new Ticket();
        ticket.setEntrytime(new Date());


        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);

        if(optionalGate.isEmpty()){
            throw new GateNotFoundException("Invalid gateId: " + gateId);
        }
        Gate gate = optionalGate.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getOperator());

        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleByVehicleNumber(vehicleNumber);
        Vehicle savedVehicle = null;

        if(optionalVehicle.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleType(vehicleType);
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setOwnerName(vehicleOwnerName);
            savedVehicle = vehicleRepository.save(vehicle);
        } else {
          savedVehicle = optionalVehicle.get();
        }
        ticket.setVehicle(savedVehicle);

        //Assign the spot;
        ParkingLot parkingLot = parkingLotRepository.getParkingLotByGateId(gateId);
        SpotAssignmentStrategyType spotAssignmentStrategyType = parkingLot.getSpotAssignmentStrategyType();

        SpotAssignmentStrategy spotAssignmentStrategy =
                SpotAssignmentStrategyFactory.getSpotAssignmentStrategyForType(spotAssignmentStrategyType);

        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(vehicleType, gate);
        ticket.setParkingSpot(parkingSpot);

        ticket.setNumber("TICKET_" + gateId + "_" + ticket.getEntrytime());

        return ticketRepository.save(ticket);
    }
}
