package linzx.homework.trains;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import linzx.homework.trains.exception.NoSuchStationException;
import linzx.homework.trains.railroad.RailSystem;

public class SearchRoutesByExactStopsTest {
	
    @Test
    public void testCalcRoutesByExactStops() throws Exception {
        String graph = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        RailSystem railSystem = new RailSystem(graph);
        RouteSearcher searcher = new RouteSearcher(railSystem);

        assertEquals(searcher.searchRoutesByExactStops('A', 'C', 4), 3);
    }
    
    @Test(expected = NoSuchStationException.class)
    public void testNoSuchStation() throws Exception {
        String graph = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        RailSystem railSystem = new RailSystem(graph);
        RouteSearcher searcher = new RouteSearcher(railSystem);

        searcher.searchRoutesByExactStops('A', 'F', 5);
    }    
}
