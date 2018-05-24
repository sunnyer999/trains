package linzx.homework.trains.algorithm;

import linzx.homework.trains.exception.NoSuchRouteException;
import linzx.homework.trains.exception.NoSuchStationException;

public interface DepthFirstSearch {
    /**
     * For example: "The number of trips starting at C and ending at C with a maximum of 3 stops.
     * In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops)."
     **/
    int searchRoutesByExactStops(char startStation, char endStation, int exactStops) throws NoSuchStationException;
    
    int searchRoutesByMaxStops(char startStation, char endStation, int maxStops) throws NoSuchStationException; 
    
    /**
     * For example: The number of different routes from C to C with a distance of less than 30.
     * In the sample data, the trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC
     **/
    int searchRoutesByMaxDistance(char startStation, char endStation, int maxDistance) throws NoSuchStationException, NoSuchRouteException;
}
