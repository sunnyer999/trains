package linzx.homework.trains;

import java.util.Vector;

import linzx.homework.trains.exception.NoSuchRouteException;
import linzx.homework.trains.exception.NoSuchStationException;


public class Utility {
	
	/**
	 * Returns the decimal map value of a town.
	 */			
	public static int toNumber(char c) {
		if( ('a' <= c) && (c <= 'z') ) {
			c -= ('a' - 'A');
		} else if( ('A' <= c) && (c <= 'Z') ) {
			c -= 'A';
		} else {
			throw new IndexOutOfBoundsException("Town " + c + " Is Invalid");
		}
		
		return c;
	}
	
	/**
	 * Returns the character map value of a town.
	 */		
	public static char toCharacter(int i) {		
		return (char)(i + 'A');
	}
	
	/**
	 * Returns an array of character elements stored in a vector.
	 */	
	public static char[] toArray(Vector<Character> v) {
		char[] ret = new char[v.size()];
        
        for(int i = 0; i < ret.length; i++) {
        	ret[i] = v.get(i);
        }
        
        return ret;
	}
	
	/**
     * Runs the 10 sample cases described in the homework.
     * 
     */	
	public static void StartSampleCaseTest(RouteSearcher searcher, RouteCalculator calculator) {
    	int distance = 0;
    	int number = 0;
    	int length;
    	
    	// Sample Case 1:     	
    	try {
    		distance = calculator.calcDistanceByRoute("A-B-C");
    		System.out.println("Output #1: " + distance);
    	} catch (NoSuchRouteException e) {
    		System.out.println("Output #1: NO SUCH ROUTE");
    	}
    	
    	// Sample Case 2:     	
    	try {
    		distance = calculator.calcDistanceByRoute("A-D");
    		System.out.println("Output #2: " + distance);
    	} catch (NoSuchRouteException e) {
    		System.out.println("Output #2: NO SUCH ROUTE");
    	}
    	
    	// Sample Case 3:     	
    	try {
    		distance = calculator.calcDistanceByRoute("A-D-C");
    		System.out.println("Output #3: " + distance);
    	} catch (NoSuchRouteException e) {
    		System.out.println("Output #3: NO SUCH ROUTE");
    	}
    	
    	// Sample Case 4:     	
    	try {
    		distance = calculator.calcDistanceByRoute("A-E-B-C-D");
    		System.out.println("Output #4: " + distance);
    	} catch (NoSuchRouteException e) {
    		System.out.println("Output #4 NO SUCH ROUTE");
    	}
    	
    	// Sample Case 5:    	
    	try {
    		distance = calculator.calcDistanceByRoute("A-E-D");
    		System.out.println("Output #5: " + distance);
    	} catch (NoSuchRouteException e) {
    		System.out.println("Output #5: NO SUCH ROUTE");
    	}

    	// Sample Case 6:    	
    	try {
    		number = searcher.searchRoutesByMaxStops('C', 'C', 3);
    		System.out.println("Output #6: " + number);
    	} catch (NoSuchStationException e) {
			e.printStackTrace();
		}

    	// Sample Case 7:    	
    	try {
    		number = searcher.searchRoutesByExactStops('A', 'C', 4);
    		System.out.println("Output #7: " + number);
    	} catch (NoSuchStationException e) {
			e.printStackTrace();
		}
    	
    	// Sample Case 8:    	
    	try {
    		length = calculator.calcShortestRoute('A', 'C');
    		System.out.println("Output #8: " + length);
    	} catch (NoSuchStationException e) {
			e.printStackTrace();
		} catch (NoSuchRouteException e) {
			e.printStackTrace();
		}
    	
    	// Sample Case 9:    	
    	try {
    		length = calculator.calcShortestRoute('B', 'B');
    		System.out.println("Output #9: " + length);
    	} catch (NoSuchStationException e) {
			e.printStackTrace();
		} catch (NoSuchRouteException e) {
			e.printStackTrace();
		} 
    	
    	// Sample Case 10:    	
    	try {
    		number = searcher.searchRoutesByMaxDistance('C', 'C', 30);
    		System.out.println("Output #10: " + number);
    	} catch (NoSuchStationException e) {
			e.printStackTrace();
		} catch (NoSuchRouteException e) {
			e.printStackTrace();
		}	
	} 
    
}
