package bh.railcode.controller;

import bh.railcode.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Barry Hollywood.
 *
 * GraphFactory builds the required Graph type.
 *
 * Test Data for the problem is used here...
 */
public class GraphFactory {

    /**
     * Calls method to build whatever Graph type is specified
     * by graphType parameter and returns it.
     *
     * @param graphType - a String representing
     *                  the type of graph to be built.
     * @return the required Graph
     * or null.
     */
    public Graph getGraph(String graphType){
        if(graphType == null){
            return null;
        }
        if(graphType.equalsIgnoreCase("RAILNETWORKGRAPH")) {
            return makeRailNetworkGraph();
        } else if (graphType.equalsIgnoreCase("AIRNETWORKGRAPH")){
            return makeAirNetworkGraph();
        }
        return null;
    }

    /**
     * Building an AirNetworkGraph.
     *
     * Method not implemented. Stub here to illustrate
     * other Graphs that GraphFactory can produce.
     * @return
     */
    private AirNetworkGraph makeAirNetworkGraph() {
        return null;
    }

    /**
     * Building a RailNetworkGraph.
     * @return RailNetworkGraph
     */
    private RailNetworkGraph makeRailNetworkGraph(){
        List<Vertex> vertexes = loadVertexList();
        List<Edge> edges = loadEdgeList(vertexes);
        return new RailNetworkGraph(vertexes, edges);
    }

    /**
     * For creating test objects
     * from the given data.
     * @return List<Vertex>
     */
    private List<Vertex> loadVertexList(){
        List<String> edgesFromA = new ArrayList<String>();
        edgesFromA.add("AB"); edgesFromA.add("AD"); edgesFromA.add("AE");
        List<String> edgesFromB = new ArrayList<String>();
        edgesFromB.add("BC");
        List<String> edgesFromC = new ArrayList<String>();
        edgesFromC.add("CD"); edgesFromC.add("CE");
        List<String> edgesFromD = new ArrayList<String>();
        edgesFromD.add("DC"); edgesFromD.add("DE");
        List<String> edgesFromE = new ArrayList<String>();
        edgesFromE.add("EB");

        List<Vertex> vertexList = new ArrayList<Vertex>();
        vertexList.add(new Vertex("A", edgesFromA));
        vertexList.add(new Vertex("B", edgesFromB));
        vertexList.add(new Vertex("C", edgesFromC));
        vertexList.add(new Vertex("D", edgesFromD));
        vertexList.add(new Vertex("E", edgesFromE));
        return vertexList;
    }

    /**
     * For creating test objects
     * from the given data.
     * @return List<Edge>
     */
    private List<Edge> loadEdgeList(List<Vertex> vList) {
        Vertex vertA = vList.get(0);
        Vertex vertB = vList.get(1);
        Vertex vertC = vList.get(2);
        Vertex vertD = vList.get(3);
        Vertex vertE = vList.get(4);

        List<Edge> edgeList = new ArrayList<Edge>();
        edgeList.add(new Edge(vertA, vertB, 5));
        edgeList.add(new Edge(vertB, vertC, 4));
        edgeList.add(new Edge(vertC, vertD, 8));
        edgeList.add(new Edge(vertD, vertC, 8));
        edgeList.add(new Edge(vertD, vertE, 6));
        edgeList.add(new Edge(vertA, vertD, 5));
        edgeList.add(new Edge(vertC, vertE, 2));
        edgeList.add(new Edge(vertE, vertB, 3));
        edgeList.add(new Edge(vertA, vertE, 7));
        return edgeList;
    }
}
