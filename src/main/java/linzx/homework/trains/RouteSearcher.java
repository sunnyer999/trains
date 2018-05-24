package linzx.homework.trains;

import java.util.Vector;


import linzx.homework.trains.algorithm.DepthFirstSearch;
import linzx.homework.trains.exception.NoSuchRouteException;
import linzx.homework.trains.exception.NoSuchStationException;
import linzx.homework.trains.railroad.RailSystem;

public class RouteSearcher implements DepthFirstSearch {
    private final RailSystem railSystem;

    public RouteSearcher(RailSystem railSystem) {
        this.railSystem = railSystem;
    }

	@Override
	public int searchRoutesByExactStops(char startStation, char endStation, int exactStops) throws NoSuchStationException {
		int count = railSystem.size();
		
		if ( 0 > Utility.toNumber(startStation) || count <= Utility.toNumber(startStation) ) {
			throw new NoSuchStationException("No Such Station: " + startStation);
		}
		
		if ( 0 > Utility.toNumber(endStation) || count <= Utility.toNumber(endStation) ) {
			throw new NoSuchStationException("No Such Station: " + endStation);
		}
		
		Vector<char[]> paths = new Vector<char[]>();
		Vector<Character> vs = new Vector<Character>();
		
		vs.add(startStation);	
		getRoutesByExactStops(startStation, endStation, 0, exactStops, vs, paths);	
		vs.remove(vs.size()-1);
		
		return paths.size();		
	}
	
	protected void getRoutesByExactStops(char s, char e, int cur, int stops, Vector<Character> vs, Vector<char[]> paths) {
		if( cur < stops ) {
			char[] adjs = railSystem.getAdjacents(s);
			
			for(int i = 0; i < adjs.length; i++) {
				vs.add(adjs[i]);				
				getRoutesByExactStops(adjs[i], e, cur+1, stops, vs, paths);				
				vs.remove(vs.size()-1);
			}
		} else {
			if( s == e ) {
				paths.add(Utility.toArray(vs));
			}
		}
	}
	
	@Override
	public int searchRoutesByMaxDistance(char startStation, char endStation, int maxDistance) throws NoSuchStationException, NoSuchRouteException {
		int count = railSystem.size();
		
		if ( 0 > Utility.toNumber(startStation) || count <= Utility.toNumber(startStation) ) {
			throw new NoSuchStationException("No Such Station: " + startStation);
		}
		
		if ( 0 > Utility.toNumber(endStation) || count <= Utility.toNumber(endStation) ) {
			throw new NoSuchStationException("No Such Station: " + endStation);
		}
        
		Vector<char[]> paths = new Vector<char[]>();
		Vector<Character> vs = new Vector<Character>(); // vertexes
		
		vs.add(startStation);
		getRoutesByMaxDistance(startStation, endStation, 0, maxDistance, vs, paths);
		vs.remove(vs.size()-1);
		
		return paths.size();
	}
	
	protected void getRoutesByMaxDistance(char s, char e, int cur, int distance, Vector<Character> vs, Vector<char[]> paths) throws NoSuchRouteException {
		if( (s == e) && (0 < cur) && (cur < distance) ) {
			paths.add(Utility.toArray(vs));
		}
		
		if( cur < distance ) {
			char[] adj = railSystem.getAdjacents(s);
			
			for(int i = 0; i < adj.length; i++) {
				vs.add(adj[i]);
				getRoutesByMaxDistance(adj[i], e, cur+railSystem.getDistance(s, adj[i]), distance, vs, paths);
				vs.remove(vs.size()-1);
			}
		} 
	}
	
	@Override
	public int searchRoutesByMaxStops(char startStation, char endStation, int maxStops) throws NoSuchStationException {
		int count = railSystem.size();
		
		if ( 0 > Utility.toNumber(startStation) || count <= Utility.toNumber(startStation) ) {
			throw new NoSuchStationException("No Such Station: " + startStation);
		}
		
		if ( 0 > Utility.toNumber(endStation) || count <= Utility.toNumber(endStation) ) {
			throw new NoSuchStationException("No Such Station: " + endStation);
		}
        
		Vector<char[]> paths = new Vector<char[]>();
		Vector<Character> vs = new Vector<Character>(); // vertexes
		
		vs.add(startStation);
		getRoutesByMaxStops(startStation, endStation, 0, maxStops, vs, paths);
		vs.remove(vs.size()-1);
		
		return paths.size();
	}
	
	protected void getRoutesByMaxStops(char s, char e, int cur, int stops, Vector<Character> vs, Vector<char[]> paths) {
		if( (s == e) && (cur > 0) && (cur <= stops) ) {
			paths.add(Utility.toArray(vs));
		}
		
		if( cur < stops ) {
			char[] adjs = railSystem.getAdjacents(s);
			
			for(int i = 0; i < adjs.length; i++) {
				vs.add(adjs[i]);
				getRoutesByMaxStops(adjs[i], e, cur+1, stops, vs, paths);
				vs.remove(vs.size()-1);
			}
		} 
	}    
}
