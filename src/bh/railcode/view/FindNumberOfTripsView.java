package bh.railcode.view;

import bh.railcode.controller.GraphFactory;
import bh.railcode.controller.NumberOfTripsAlgorithm;
import bh.railcode.model.Graph;

/**
 * Created by Barry Hollywood.
 * To display the results for questions 6. and 7. Find number of trips...
 */
public class FindNumberOfTripsView implements GenericView {

    GraphFactory graphFactory = new GraphFactory();
    NumberOfTripsAlgorithm numberOfTripsAlgorithm = new NumberOfTripsAlgorithm(graphFactory.getGraph("RailNetworkGraph"));

    public void display(){
        System.out.println("======================================================");
        System.out.println("|          Rail Service :: Find Number of Trips      |");
        System.out.println("======================================================");
        System.out.println("| 6. Starting at C and ending at C with max 3 stops.  ");
        System.out.println("|    Output should be 2 (C-E-B-C and C-D-C)                  ");
        System.out.println("|    Output: " + numberOfTripsAlgorithm.numberOfTripsMax("C","C",3) + " ");
        System.out.println("| 7. Starting at A and ending at C with exactly 4 stops.  ");
        System.out.println("|    Output should be 3 (via B,C,D, and D,C,D, and D,E,B)    ");
        System.out.println("|    Output: " + numberOfTripsAlgorithm.numberOfTripsExact("A","C",4) + " ");
        System.out.println("======================================================");
    }

}
