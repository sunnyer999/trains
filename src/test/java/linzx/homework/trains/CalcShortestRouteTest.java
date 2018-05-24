package linzx.homework.trains;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import linzx.homework.trains.exception.NoSuchRouteException;
import linzx.homework.trains.exception.NoSuchStationException;
import linzx.homework.trains.railroad.RailSystem;

public class CalcShortestRouteTest {
	
    @Test
    public void testCalcDistanceByRoute() throws Exception {
        String graph = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        RailSystem railSystem = new RailSystem(graph);
        RouteCalculator calculator = new RouteCalculator(railSystem);

        assertEquals(calculator.calcShortestRoute('A', 'C'), 9);
        assertEquals(calculator.calcShortestRoute('B', 'B'), 9);
    }

    @Test(expected = NoSuchRouteException.class)
    public void testNoSuchRoute() throws Exception {
        String graph = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        RailSystem railSystem = new RailSystem(graph);
        RouteCalculator calculator = new RouteCalculator(railSystem);

        calculator.calcShortestRoute('E', 'A');
    }
    
    @Test(expected = NoSuchStationException.class)
    public void testNoSuchStation() throws Exception {
        String graph = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        RailSystem railSystem = new RailSystem(graph);
        RouteCalculator calculator = new RouteCalculator(railSystem);

        calculator.calcShortestRoute('A', 'F');
    }
}
