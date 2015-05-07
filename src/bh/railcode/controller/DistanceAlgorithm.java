package bh.railcode.controller;

import bh.railcode.model.Edge;
import bh.railcode.model.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Barry Hollywood.
 *
 * Calculates the total distance taken to travel a given route
 * and returns value as a String. If route is invalid the returned
 * value will be 'NO SUCH ROUTE'.
 */
public class DistanceAlgorithm {
    private final List<Edge> edges;
    public DistanceAlgorithm(Graph graph) {
        this.edges = new ArrayList<Edge>(graph.getEdges());
    }

    /**
     *
     * @param route - a String representing a route
     * @return finalDistance - a String representing
     * the total distance taken to travel the route
     * of if the route is invalid it will be of
     * value 'NO SUCH ROUTE'.
     */
    public String calculateRouteDistance(String route){
        String finalDistance = "";
        int totalDistance = 0;
        for(String s : splitRoute(route)){
            int count = 0;
            for(Edge e : edges){
                if(e.toString().equals(s)) {
                    totalDistance += e.getWeight();
                    count++;
                }
            }
            if(count == 0){
                totalDistance = 0;
            }
        }

        if(totalDistance == 0)
            finalDistance = "NO SUCH ROUTE";
        else
            finalDistance = Integer.toString(totalDistance);

        return finalDistance;
    }

    /**
     * Splits given route String into edges and
     * returns as a list.
     * @param route - a String representing a route
     * @return edgeStringList - a list of edges
     */
    private List<String> splitRoute(String route){

        List<String> edgeStringList = new ArrayList<String>();

        if(route.length() > 1) {
            for (int i = 0; i < route.length() - 1; i++) {
                String r = String.valueOf(route.charAt(i) + "" + route.charAt(i+1));
                edgeStringList.add(r);
            }
        } else {
            edgeStringList.add("Invalid route...");
        }

        return edgeStringList;
    }
}
