package bh.railcode.model;

import java.util.List;

/**
 * Created by Barry Hollywood.
 *
 * Representation of a RailNetworkGraph.
 */
public class RailNetworkGraph implements Graph {
    private final List<Vertex> vertexes;
    private final List<Edge> edges;

    public RailNetworkGraph(List<Vertex> vertexes, List<Edge> edges){
        this.vertexes = vertexes;
        this.edges = edges;
    }

    @Override
    public List<Vertex> getVertexes() {
        return vertexes;
    }

    @Override
    public List<Edge> getEdges() {
        return edges;
    }
}
