package org.example.ParkingLot.Factory;

import org.example.ParkingLot.Models.SpotAssignmentStrategyType;
import org.example.ParkingLot.Strategies.RandomSpotAssignmentStrategy;
import org.example.ParkingLot.Strategies.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategyForType(
            SpotAssignmentStrategyType spotAssignmentStrategyType){
        return new RandomSpotAssignmentStrategy();
    }
}
