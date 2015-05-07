package bh.railcode.controller;

import bh.railcode.model.Edge;
import bh.railcode.model.Graph;
import bh.railcode.model.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Barry Hollywood.
 *
 * Calculate the number of trips between two points.
 */
public class NumberOfTripsAlgorithm {
    private Graph graph;
    private List<Vertex> vertexes;
    private List<Edge> edges;
    private List<String> routeList = new ArrayList<String>();

    public NumberOfTripsAlgorithm (Graph graph) {
        this.graph = graph;
        vertexes = graph.getVertexes();
        edges = graph.getEdges();
    }

    /**
     * Calculate the number of trips between source
     * and destination given a maximum number of stops.
     * @param source - starting point.
     * @param destination - ending point.
     * @param maxStops - maximum number of stops.
     * @return validRoutesNum - number of valid routes.
     */
    public int numberOfTripsMax(String source, String destination, int maxStops) {
        int validRoutesNum = 0;
        getRouteList(source, maxStops, "");
        routeList = FormatRoutesList.formatRoutesList(routeList);
        for(String routeString : routeList){
            if(String.valueOf(routeString.charAt(0)).equals(source)
                    && String.valueOf(routeString.charAt(routeString.length()-1)).equals(destination)) {
                validRoutesNum++;
                System.out.println("|     Valid route " + validRoutesNum + " is " + routeString);
            }
        }
        return validRoutesNum;
    }

    /**
     * Calculate the number of trips between source
     * and destination given an exact number of stops.
     * @param source - starting point.
     * @param destination - ending point.
     * @param exactStops - exact number of stops.
     * @return validRoutesNum - number of valid routes.
     */
    public int numberOfTripsExact(String source, String destination, int exactStops) {
        int validRoutesNum = 0;
        getRouteList(source, exactStops, "");
        routeList = FormatRoutesList.formatRoutesList(routeList);
        for(String routeString : routeList){
            if(String.valueOf(routeString.charAt(0)).equals(source)
                    && String.valueOf(routeString.charAt(routeString.length()-1)).equals(destination)
                    && routeString.length() == exactStops + 1) {
                validRoutesNum++;
                System.out.println("|     Valid route " + validRoutesNum + " is " + routeString);
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
