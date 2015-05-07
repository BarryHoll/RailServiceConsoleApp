package bh.railcode.view;

import bh.railcode.controller.DistanceAlgorithm;
import bh.railcode.controller.GraphFactory;

/**
 * Created by Barry Hollywood.
 * To display the results of questions 1. to 5. Find the distance...
 */
public class FindTheDistanceView  implements GenericView{

    GraphFactory graphFactory = new GraphFactory();
    DistanceAlgorithm distanceAlgorithm = new DistanceAlgorithm(graphFactory.getGraph("RailNetworkGraph"));

    public void display(){
        System.out.println("===================================================");
        System.out.println("|          Rail Service :: Find the Distance      |");
        System.out.println("===================================================");
        System.out.println("| 1. The distance of the route ABC:   " + distanceAlgorithm.calculateRouteDistance("ABC"));
        System.out.println("| 2. The distance of the route AD:    " + distanceAlgorithm.calculateRouteDistance("AD"));
        System.out.println("| 3. The distance of the route ADC:   " + distanceAlgorithm.calculateRouteDistance("ADC"));
        System.out.println("| 4. The distance of the route AEBCD: " + distanceAlgorithm.calculateRouteDistance("AEBCD"));
        System.out.println("| 5. The distance of the route AED:   " + distanceAlgorithm.calculateRouteDistance("AED"));
        System.out.println("===================================================");
    }
}
