package bh.railcode.controller;

import bh.railcode.model.Graph;
import bh.railcode.model.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Barry Hollywood.
 *
 * Calculate the number of routes from a start point
 * to a destination given a maximum distance.
 */
public class NumberOfRoutesAlgorithm {
    private Graph graph;
    private List<Vertex> vertexes;
    private List<String> routeList = new ArrayList<String>();

    public NumberOfRoutesAlgorithm (Graph graph) {
        this.graph = graph;
        vertexes = graph.getVertexes();
    }

    /**
     * Given source, destination, maxDistance, and estimatedStops,
     * return number of valid routes.
     * @param source - starting point
     * @param destination - ending point
     * @param maxDistance - maximum distance allowed
     * @param estimatedStops - an estimation of how many stops it will take.
     *                       Better to er on the side of too many. Too few
     *                       and maximum distance may not be hit.
     * @return validRoutesNum is the total number of routes that match the input info.
     */
    public int numberOfRoutesMax(String source, String destination, int maxDistance, int estimatedStops) {
        DistanceAlgorithm distanceAlgorithm = new DistanceAlgorithm(graph);
        int validRoutesNum = 0;
        getRouteList(source, estimatedStops, "");
        routeList = FormatRoutesList.formatRoutesList(routeList);
        for(String routeString : routeList){
            if(String.valueOf(routeString.charAt(0)).equals(source)
                    && String.valueOf(routeString.charAt(routeString.length()-1)).equals(destination)
                    && Integer.valueOf(distanceAlgorithm.calculateRouteDistance(routeString)) < maxDistance) {
                validRoutesNum++;
                System.out.println("|        Valid route " + validRoutesNum + " is " + routeString);
            }
        }
        return validRoutesNum;
    }

    /**
     * Recursive method to build a list of all routes from source up to maxStops.
     * @param source - starting point for this iteration.
     * @param maxStops - remaining maxStops.
     * @param pathStart - prefix string for building a route.
     */
    private void getRouteList(String source, int maxStops, String pathStart) {
        Vertex currentVertex = null;
        for(Vertex v : vertexes){
            if(v.toString().equals(source)) currentVertex = v;
        }
        if(maxStops == 1){
            for(String edg : currentVertex.getEdgesLeaving()){
                pathStart = pathStart + source;
                String newSource = String.valueOf(edg.charAt(1));
                routeList.add(pathStart + newSource);
            }
        } else {
            if (currentVertex != null) {
                for (String edg : currentVertex.getEdgesLeaving()) {
                    pathStart = pathStart + source;
                    String newSource = String.valueOf(edg.charAt(1));
                    routeList.add(pathStart + newSource);
                    getRouteList(newSource, maxStops - 1, pathStart);
                }
            }
        }
    }
}
