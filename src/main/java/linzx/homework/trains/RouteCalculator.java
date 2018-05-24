package linzx.homework.trains;

import linzx.homework.trains.algorithm.Floyd;
import linzx.homework.trains.exception.NoSuchRouteException;
import linzx.homework.trains.exception.NoSuchStationException;
import linzx.homework.trains.railroad.RailSystem;
import linzx.homework.trains.railroad.Station;

public class RouteCalculator implements Floyd {
    private final RailSystem railSystem;
    private int[][] shortestDistances = null;
    private int[][] shortestPaths = null;
	
    public RouteCalculator(RailSystem railSystem) {
        this.railSystem = railSystem;
    }


    /**
     * For example: "The distance of the route A-B-C."
     **/
    public int calcDistanceByRoute(String route) throws NoSuchRouteException {
        int distance = 0;
        String[] stationNames = route.split("-");

        for (int i = 0; i < stationNames.length - 1; i++) {
            Station fromStation = railSystem.getStationMap().get(stationNames[i].charAt(0));
            Station toStation = railSystem.getStationMap().get(stationNames[i + 1].charAt(0));
            distance += fromStation.getDistanceTo(toStation);
        }

        return distance;
    }

    /**
     * For example: "The length of the shortest route (in terms of distance to travel) from A to C"
     * @throws NoSuchStationException 
     **/
	@Override
	public int calcShortestRoute(char startStation, char endStation) throws NoSuchRouteException, NoSuchStationException {
		int ret = 0;
		int count = railSystem.size();
		
		if ( 0 > Utility.toNumber(startStation) || count <= Utility.toNumber(startStation) ) {
			throw new NoSuchStationException("No Such Station: " + startStation);
		}
		
		if ( 0 > Utility.toNumber(endStation) || count <= Utility.toNumber(endStation) ) {
			throw new NoSuchStationException("No Such Station: " + endStation);
		}
		
		if( (shortestDistances == null) && (shortestPaths == null) ) {
	        shortestDistances = new int[count][count];
	        shortestPaths = new int[count][count];
	
	        for(int i = 0; i < count; i++) {
	                for(int j = 0; j < count; j++) {     	            	
	                    if( railSystem.isAdjacent(Utility.toCharacter(i), Utility.toCharacter(j))) {
	                    	shortestPaths[i][j] = j;
	                    	shortestDistances[i][j] = railSystem.getDistance(Utility.toCharacter(i), Utility.toCharacter(j));
	                    } else {
	                    	shortestPaths[i][j] = -1;
	                    	shortestDistances[i][j] = Short.MAX_VALUE;
	                    }
	                }
	            }
	
	            for(int k = 0; k < count; k++) {
	                for(int i = 0; i < count; i++) {
	                    for(int j = 0; j < count; j++) {
	                        if( (shortestDistances[i][k] + shortestDistances[k][j]) < shortestDistances[i][j] ) {
	                            shortestDistances[i][j] = shortestDistances[i][k] + shortestDistances[k][j];
	                            shortestPaths[i][j] = shortestPaths[i][k];
	                        }
	                    }
	                }
	           }
        }
		
		ret = shortestDistances[Utility.toNumber(startStation)][Utility.toNumber(endStation)];
		
		if (ret >= Short.MAX_VALUE) {
			throw new NoSuchRouteException("There is No Route from: " + startStation + " To " + endStation);
		} 
		
		return ret;
	}
	  
}
