package linzx.homework.trains;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import linzx.homework.trains.railroad.RailSystem;


public class Main {

    public static void main(String[] args) {
    	System.out.print("Please input the file name: ");
    	
    	Scanner s = new Scanner(System.in);
    	String file = s.next();	
        String content = null;
        
        try {
        	BufferedReader br = new BufferedReader(new FileReader(file));
        	
			while((content = br.readLine()) != null) {
				RailSystem railSystem = new RailSystem(content);
		        RouteSearcher searcher = new RouteSearcher(railSystem);
		        RouteCalculator calculator = new RouteCalculator(railSystem);
		        Utility.StartSampleCaseTest(searcher, calculator);
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("The input file does not exist.");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		s.close();
    }

}
