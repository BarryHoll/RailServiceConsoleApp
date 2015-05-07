package bh.railcode.view;

import bh.railcode.controller.GraphFactory;
import bh.railcode.controller.NumberOfRoutesAlgorithm;
import bh.railcode.model.Graph;

/**
 * Created by Barry Hollywood.
 * To display the results for question 10. Find number of routes...
 */
public class FindNumberOfRoutesView  implements GenericView {

    GraphFactory graphFactory = new GraphFactory();
    NumberOfRoutesAlgorithm numberOfRoutesAlgorithm = new NumberOfRoutesAlgorithm(graphFactory.getGraph("RailNetworkGraph"));

    public void display(){
        System.out.println("=====================================================");
        System.out.println("|        Rail Service :: Find Number of Routes      |");
        System.out.println("=====================================================");
        System.out.println("| 10. Different routes from C to C with a distance   ");
        System.out.println("|       of less than 30. Expected output is 7.       ");
        System.out.println("|     Output: " + numberOfRoutesAlgorithm.numberOfRoutesMax("C", "C", 30, 10) + " ");
        System.out.println("=====================================================");
    }
}
