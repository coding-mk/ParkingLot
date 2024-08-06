package org.example.ParkingLot.Strategies;

import org.example.ParkingLot.Models.Gate;
import org.example.ParkingLot.Models.ParkingSpot;
import org.example.ParkingLot.Models.VehicleType;
import org.example.ParkingLot.Repository.ParkingLotRepository;

public class RandomSpotAssignmentStrategy implements  SpotAssignmentStrategy{
    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate) {
        ParkingLotRepository.getParkingLotByGateId(gate.getId());
        return null;
    }
}
