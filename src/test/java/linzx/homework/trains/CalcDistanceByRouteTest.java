package linzx.homework.trains;


import org.junit.Test;

import linzx.homework.trains.exception.NoSuchRouteException;
import linzx.homework.trains.railroad.RailSystem;

import static org.junit.Assert.assertEquals;


public class CalcDistanceByRouteTest {

    @Test
    public void testCalcDistanceByRoute() throws Exception {
        String graph = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        RailSystem railSystem = new RailSystem(graph);
        RouteCalculator calculator = new RouteCalculator(railSystem);

        assertEquals(calculator.calcDistanceByRoute("A-B-C"), 9);
        assertEquals(calculator.calcDistanceByRoute("A-D"), 5);
        assertEquals(calculator.calcDistanceByRoute("A-D-C"), 13);
        assertEquals(calculator.calcDistanceByRoute("A-E-B-C-D"), 22);
    }


    @Test(expected = NoSuchRouteException.class)
    public void testNoSuchRoute() throws Exception {
        String graph = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        RailSystem railSystem = new RailSystem(graph);
        RouteCalculator calculator = new RouteCalculator(railSystem);

        calculator.calcDistanceByRoute("A-E-D");
    }

}
