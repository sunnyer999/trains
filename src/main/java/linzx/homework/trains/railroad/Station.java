package linzx.homework.trains.railroad;


import java.util.HashMap;

import linzx.homework.trains.exception.NoSuchRouteException;

public class Station {
    private final char name;
    private final HashMap<Station, Integer> distanceMap;

    Station(char name) {
        this.name = name;
        this.distanceMap = new HashMap<>();
    }

    void addConnection(Station station, int distance) {
        this.distanceMap.put(station, distance);
    }
    
    public int getDistanceTo(Station station) throws NoSuchRouteException {
        if (distanceMap.containsKey(station)) {
            return distanceMap.get(station);
        }
        
        throw new NoSuchRouteException(String.format("No Such %s!", station.toString()));
    }
    
    public char getName( ) {
    	return this.name;
    }  
    
    public HashMap<Station, Integer> getDistanceMap( ) {
    	return this.distanceMap;
    }  
    
    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                '}';
    }

}
