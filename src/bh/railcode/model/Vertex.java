package bh.railcode.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Barry Hollywood.
 *
 * A 'Vertex' represents a given node in a Graph.
 */
public class Vertex {
    final private String name;
    private List<String> edgesLeaving = new ArrayList<String>();

    public Vertex(String name, List<String> edgesLeaving){
        this.name = name;
        this.edgesLeaving = edgesLeaving;
    }

    public List<String> getEdgesLeaving() {
        return edgesLeaving;
    }

    @Override
    public String toString(){
        return name;
    }
}
