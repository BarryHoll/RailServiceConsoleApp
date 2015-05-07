package bh.railcode.view;

import bh.railcode.controller.GraphFactory;
import bh.railcode.controller.ShortestRouteAlgorithm;
import bh.railcode.model.Graph;

/**
 * Created by Barry Hollywood.
 * To display the results of questions 8. and 9. Find length of shortest route...
 */
public class FindShortestRouteView implements GenericView {

    GraphFactory graphFactory = new GraphFactory();
    ShortestRouteAlgorithm shortestRouteAlgorithm = new ShortestRouteAlgorithm(graphFactory.getGraph("RailNetworkGraph"));

    public void display(){
        System.out.println("=============================================================");
        System.out.println("|        Rail Service :: Find Length of Shortest Route      |");
        System.out.println("=============================================================");
        System.out.println("| 8. Shortest route from A to C. Expected Output: 9 " );
        System.out.println("|    Output: " + shortestRouteAlgorithm.lengthOfShortestRoute("A", "C", 6) + " ");
        System.out.println("| 9. Shortest route from B to B. Expected Output: 9 " );
        System.out.println("|    Output: " + shortestRouteAlgorithm.lengthOfShortestRoute("B", "B", 6) + " ");
        System.out.println("=============================================================");
    }
}
