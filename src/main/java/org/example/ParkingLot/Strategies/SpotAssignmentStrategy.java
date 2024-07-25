package org.example.ParkingLot.Strategies;

import org.example.ParkingLot.Models.Gate;
import org.example.ParkingLot.Models.ParkingSpot;
import org.example.ParkingLot.Models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(VehicleType vehicleType, Gate gate);
}
