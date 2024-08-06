package org.example.ParkingLot.Repository;

import org.example.ParkingLot.Models.Vehicle;

import java.util.HashMap;
import java.util.*;
import java.util.Optional;

public class VehicleRepository {
    private Map<String, Vehicle> vehicles = new HashMap<>();

    public Optional<Vehicle> findVehicleByVehicleNumber(String vehicleNumber) {
        if(vehicles.containsKey(vehicleNumber)) {
            return Optional.of(vehicles.get(vehicleNumber));
        }
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle){
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setOwnerName(vehicle.getOwnerName());
        vehicle1.setVehicleType(vehicle.getVehicleType());
        vehicle1.setVehicleNumber(vehicle.getVehicleNumber());
        vehicles.put(vehicle.getVehicleNumber(), vehicle1);
        return vehicle1;
    }
}
