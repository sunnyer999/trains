package linzx.homework.trains;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import linzx.homework.trains.exception.NoSuchStationException;
import linzx.homework.trains.railroad.RailSystem;

public class SearchRoutesByMaxStopsTest {
	
    @Test
    public void testSearchRoutesByMaxDistance() throws Exception {
        String graph = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        RailSystem railSystem = new RailSystem(graph);
        RouteSearcher searcher = new RouteSearcher(railSystem);

        assertEquals(searcher.searchRoutesByMaxStops('C', 'C', 3), 2);
    }
    
    @Test(expected = NoSuchStationException.class)
    public void testNoSuchStation() throws Exception {
        String graph = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        RailSystem railSystem = new RailSystem(graph);
        RouteSearcher searcher = new RouteSearcher(railSystem);

        searcher.searchRoutesByMaxStops('A', 'F', 5);
    } 
    
}
