package linzx.homework.trains.railroad;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import linzx.homework.trains.exception.NoSuchRouteException;

public class RailSystem {
    private final HashMap<Character, Station> stationMap = new HashMap<>();

    public RailSystem(String graph) {
        String[] routes = graph.split(",");
        for (String route : routes) {
            addRoute(route.trim());
        }
    }

    private void addRoute(String route) {
        char[] tmp = route.toCharArray();
        char start = tmp[0];
        char end = tmp[1];
        int distance = Character.getNumericValue(tmp[2]);

        if (!stationMap.containsKey(start)) {
            stationMap.put(start, new Station(start));
        }

        if (!stationMap.containsKey(end)) {
            stationMap.put(end, new Station(end));
        }

        stationMap.get(start).addConnection(stationMap.get(end), distance);
    }

    public HashMap<Character, Station> getStationMap() {
        return stationMap;
    }
    
    public int size() {
        return stationMap.size();
    }  
    
    public boolean isAdjacent(char start, char end) {
    	if ( !stationMap.containsKey(start) || !stationMap.containsKey(end)) {
    		return false;
    	} 
    	
    	return stationMap.get(start).getDistanceMap().containsKey(stationMap.get(end));
    }
    
    public int getDistance(char start, char end) throws NoSuchRouteException {
    	if ( !stationMap.containsKey(start) || !stationMap.containsKey(end)) {
    		return Short.MAX_VALUE;
    	} 
    	
    	return stationMap.get(start).getDistanceTo(stationMap.get(end));
    }

	public char[] getAdjacents(char station) {
    	if ( !stationMap.containsKey(station) ) {
    		return null;
    	} 
    	
    	Set<Station> set = stationMap.get(station).getDistanceMap().keySet();
    	Iterator<Station> it = set.iterator(); 
    	char[] ret = new char[set.size()];
    	
    	int i = 0;
    	while (it.hasNext()) {   
    		ret[i++] = it.next().getName();   
    	}
    	
		return ret;
	} 
}
