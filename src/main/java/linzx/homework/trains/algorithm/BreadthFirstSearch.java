package linzx.homework.trains.algorithm;

public interface BreadthFirstSearch {
    /**
     * For example: "The number of trips starting at C and ending at C with a maximum of 3 stops.
     * In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops)."
     **/
    int searchRoutesByExactStops(String startStation, String endStation, int maxStops);
    
    /**
     * For example: The number of different routes from C to C with a distance of less than 30.
     * In the sample data, the trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC
     **/
    int searchRoutesByMaxDistance(String startStation, String endStation, int maxDistance);
}
