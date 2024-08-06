package org.example.ParkingLot.Repository;

import org.example.ParkingLot.Models.Gate;

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
        gateMap.put(1L, new Gate());
        gateMap.put(2L, new Gate());
        gateMap.put(3L, new Gate());
        gateMap.put(4L, new Gate());
        gateMap.put(5L, new Gate());
        gateMap.put(6L, new Gate());
        gateMap.put(7L, new Gate());
        gateMap.put(8L, new Gate());
        gateMap.put(9L, new Gate());
    }

}
