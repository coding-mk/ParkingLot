package org.example.ParkingLot.Repository;

import org.example.ParkingLot.Models.Gate;
import org.example.ParkingLot.Models.GateStatus;
import org.example.ParkingLot.Models.GateType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    public static Map<Long, Gate> gateMap = new HashMap<>();

    public Optional<Gate> findGateById(Long gateId){
        addGateDetails();
        if(gateMap.containsKey(gateId)){
            return Optional.of(gateMap.get(gateId));
        }
        return Optional.empty();
    }

    private void addGateDetails(){
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

        gateMap.put(1L, gate1);
        gateMap.put(2L, gate2);
        gateMap.put(3L, gate3);
        gateMap.put(4L, gate4);
        gateMap.put(5L, gate5);
        gateMap.put(6L, gate6);
        gateMap.put(7L, gate7);
        gateMap.put(8L, gate8);
    }

}
