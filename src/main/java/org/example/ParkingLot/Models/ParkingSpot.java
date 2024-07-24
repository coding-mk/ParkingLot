package org.example.ParkingLot.Models;

import java.util.List;

public class ParkingSpot {
    private ParkingSpotStatus parkingSpotStatus;
    private List<VehicleType> supportedVehicalType;
    private int spotNumber;
    private ParkingFloor parkingFloor;

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public List<VehicleType> getSupportedVehicalType() {
        return supportedVehicalType;
    }

    public void setSupportedVehicalType(List<VehicleType> supportedVehicalType) {
        this.supportedVehicalType = supportedVehicalType;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }
}
