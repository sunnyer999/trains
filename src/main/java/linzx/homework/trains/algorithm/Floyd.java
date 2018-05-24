package linzx.homework.trains.algorithm;

import linzx.homework.trains.exception.NoSuchRouteException;
import linzx.homework.trains.exception.NoSuchStationException;

public interface Floyd {
    /**
     * For example: "The length of the shortest route (in terms of distance to travel) from A to C"
     * @throws NoSuchRouteException 
     **/
    int calcShortestRoute(char startStation, char endStation) throws NoSuchRouteException, NoSuchStationException;
}
