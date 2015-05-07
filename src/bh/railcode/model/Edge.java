package bh.railcode.model;

/**
 * Created by Barry Hollywood.
 *
 * An 'Edge' represents the path between two nodes.
 */
public class Edge {
    private final Vertex source;
    private final Vertex destination;
    private final int weight;

    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString(){
        return source + "" + destination;
    }
}
