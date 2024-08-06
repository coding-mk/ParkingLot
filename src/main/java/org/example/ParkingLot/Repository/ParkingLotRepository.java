package org.example.ParkingLot.Repository;

import org.example.ParkingLot.Models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLotRepository {
    public static List<ParkingLot> parkingLotList = new ArrayList<>();

    public static ParkingLot getParkingLotByGateId(Long gateId){
        List<Long> gatesId = new ArrayList<>();
        for(ParkingLot parkingLot : parkingLotList) {
            gatesId = parkingLot.getGates().stream().map((x) -> x.getId()).toList();
            if(gatesId.contains(gateId)){
                return parkingLot;
            }
        }
        return new ParkingLot();
    }

    private void addParkingLots() {
        ParkingLot parkingLot1 = new ParkingLot();
        parkingLot1.setParkingFloors(getParkingFloor());
        parkingLot1.setId(1L);
        parkingLot1.setSpotAssignmentStrategyType(SpotAssignmentStrategyType.NEAREST);
        parkingLot1.setFeeCalculationStrategyType(FeeCalculationStrategyType.WEEKEND);
        parkingLot1.setGates(getGateList(1));

        ParkingLot parkingLot2 = new ParkingLot();
        parkingLot2.setParkingFloors(getParkingFloor());
        parkingLot2.setId(2L);
        parkingLot1.setSpotAssignmentStrategyType(SpotAssignmentStrategyType.NEAREST);
        parkingLot1.setFeeCalculationStrategyType(FeeCalculationStrategyType.WEEKEND);
        parkingLot2.setGates(getGateList(2));

        ParkingLot parkingLot3 = new ParkingLot();
        parkingLot3.setParkingFloors(getParkingFloor());
        parkingLot3.setId(2L);
        parkingLot1.setSpotAssignmentStrategyType(SpotAssignmentStrategyType.NEAREST);
        parkingLot1.setFeeCalculationStrategyType(FeeCalculationStrategyType.WEEKEND);
        parkingLot3.setGates(getGateList(0));

        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        parkingLotList.add(parkingLot3);
    }

    private List<Gate> getGateList(int id){
        Gate gate1 = new Gate();
        gate1.setId(1L);
        gate1.setGateNumber(1);
        gate1.setGateStatus(GateStatus.OPENED);
        gate1.setGateType(GateType.ENTRY);

        Gate gate2 = new Gate();
        gate1.setId(2L);
        gate1.setGateNumber(2);
        gate1.setGateStatus(GateStatus.OPENED);
        gate1.setGateType(GateType.ENTRY);

        Gate gate3 = new Gate();
        gate1.setId(3L);
        gate1.setGateNumber(3);
        gate1.setGateStatus(GateStatus.OPENED);
        gate1.setGateType(GateType.ENTRY);

        Gate gate4 = new Gate();
        gate1.setId(4L);
        gate1.setGateNumber(4);
        gate1.setGateStatus(GateStatus.OPENED);
        gate1.setGateType(GateType.ENTRY);

        Gate gate5 = new Gate();
        gate1.setId(5L);
        gate1.setGateNumber(5);
        gate1.setGateStatus(GateStatus.OPENED);
        gate1.setGateType(GateType.EXIT);

        Gate gate6 = new Gate();
        gate1.setId(6L);
        gate1.setGateNumber(6);
        gate1.setGateStatus(GateStatus.OPENED);
        gate1.setGateType(GateType.EXIT);

        Gate gate7 = new Gate();
        gate1.setId(7L);
        gate1.setGateNumber(7);
        gate1.setGateStatus(GateStatus.OPENED);
        gate1.setGateType(GateType.EXIT);

        Gate gate8 = new Gate();
        gate1.setId(8L);
        gate1.setGateNumber(8);
        gate1.setGateStatus(GateStatus.OPENED);
        gate1.setGateType(GateType.EXIT);

        if(id == 1)
        {
            return Arrays.asList(gate1, gate2);
        }
        if(id == 2){
            return Arrays.asList(gate3, gate4);
        }
        return Arrays.asList(gate1, gate2, gate3, gate4, gate5, gate6, gate7, gate8);
    }

    private List<ParkingFloor> getParkingFloor(){
        ParkingFloor parkingFloor1 = new ParkingFloor();
        parkingFloor1.setFloorNumber(1);
        parkingFloor1.setParkingSpots(getParkingSpot());
        parkingFloor1.setParkingFloorStatus(ParkingFloorStatus.OPERATIONAL);
        parkingFloor1.setId(1L);

        ParkingFloor parkingFloor2 = new ParkingFloor();
        parkingFloor1.setFloorNumber(2);
        parkingFloor1.setParkingSpots(getParkingSpot());
        parkingFloor1.setParkingFloorStatus(ParkingFloorStatus.OPERATIONAL);
        parkingFloor1.setId(2L);

        ParkingFloor parkingFloor3 = new ParkingFloor();
        parkingFloor1.setFloorNumber(3);
        parkingFloor1.setParkingSpots(getParkingSpot());
        parkingFloor1.setParkingFloorStatus(ParkingFloorStatus.OPERATIONAL);
        parkingFloor1.setId(3L);

        ParkingFloor parkingFloor4 = new ParkingFloor();
        parkingFloor1.setFloorNumber(4);
        parkingFloor1.setParkingSpots(getParkingSpot());
        parkingFloor1.setParkingFloorStatus(ParkingFloorStatus.OPERATIONAL);
        parkingFloor1.setId(4L);

        ParkingFloor parkingFloor5 = new ParkingFloor();
        parkingFloor1.setFloorNumber(5);
        parkingFloor1.setParkingSpots(getParkingSpot());
        parkingFloor1.setParkingFloorStatus(ParkingFloorStatus.OPERATIONAL);
        parkingFloor1.setId(5L);

        return Arrays.asList(parkingFloor1, parkingFloor2, parkingFloor3, parkingFloor4, parkingFloor5);
    }

    private List<ParkingSpot> getParkingSpot(){
        ParkingSpot parkingSpot1 = new ParkingSpot();
        parkingSpot1.setSpotNumber(1);
        parkingSpot1.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot1.setSupportedVehicalType(supportedVehicle("FourWheeler"));

        ParkingSpot parkingSpot2 = new ParkingSpot();
        parkingSpot1.setSpotNumber(2);
        parkingSpot1.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot1.setSupportedVehicalType(supportedVehicle("TwoWheeler"));

        ParkingSpot parkingSpot3 = new ParkingSpot();
        parkingSpot1.setSpotNumber(3);
        parkingSpot1.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot1.setSupportedVehicalType(supportedVehicle("FourWheeler"));

        ParkingSpot parkingSpot4 = new ParkingSpot();
        parkingSpot1.setSpotNumber(4);
        parkingSpot1.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot1.setSupportedVehicalType(supportedVehicle("FourWheeler"));

        ParkingSpot parkingSpot5 = new ParkingSpot();
        parkingSpot1.setSpotNumber(5);
        parkingSpot1.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot1.setSupportedVehicalType(supportedVehicle("FourWheeler"));

        ParkingSpot parkingSpot6 = new ParkingSpot();
        parkingSpot1.setSpotNumber(6);
        parkingSpot1.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        parkingSpot1.setSupportedVehicalType(supportedVehicle("FourWheeler"));

        return Arrays.asList(parkingSpot1, parkingSpot2, parkingSpot3, parkingSpot4, parkingSpot5, parkingSpot6);
    }

    private List<VehicleType> supportedVehicle(String Vehicletype){
        if(Vehicletype.equals("FourWheeler")){
            return Arrays.asList(VehicleType.SUV, VehicleType.SEDAN);
        }
        return Arrays.asList(VehicleType.TWO_WHEELER);
    }

}
