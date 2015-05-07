package bh.railcode.controller;

import bh.railcode.model.Edge;
import bh.railcode.model.Graph;
import bh.railcode.model.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Barry on 30/08/2014.
 *
 * Calculate the length of the shortest route between two points.
 */
public class ShortestRouteAlgorithm {
    private Graph graph;
    private List<Vertex> vertexes;
    private List<Edge> edges;
    private List<String> routeList = new ArrayList<String>();

    public ShortestRouteAlgorithm(Graph graph){
        this.graph = graph;
        vertexes = graph.getVertexes();
        edges = graph.getEdges();
    }

    /**
     *
     * @param source - starting point.
     * @param destination - ending point.
     * @param maxStops - maximum number of stops.
     * @return shortestLength - returns the shortest route value
     * of all valid routes.
     */
    public int lengthOfShortestRoute(String source, String destination, int maxStops) {
        List<String> validRoutes = new ArrayList<String>();
        DistanceAlgorithm distanceAlgorithm = new DistanceAlgorithm(graph);
        getRouteList(source, maxStops, "");
        routeList = FormatRoutesList.formatRoutesList(routeList);
        for(String routeString : routeList){
            if(String.valueOf(routeString.charAt(0)).equals(source)
                    && String.valueOf(routeString.charAt(routeString.length()-1)).equals(destination)) {
                validRoutes.add(routeString);
            }
        }
        int routeLength = 0;
        int shortestLength = 99999;
        for(String routeStr : validRoutes){
            routeLength = Integer.valueOf(distanceAlgorithm.calculateRouteDistance(routeStr));
            if(routeLength < shortestLength){
                shortestLength = routeLength;
            }
        }
        return shortestLength;
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
