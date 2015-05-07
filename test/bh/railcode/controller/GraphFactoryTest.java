package bh.railcode.controller;

import bh.railcode.model.AirNetworkGraph;
import bh.railcode.model.Graph;
import bh.railcode.model.RailNetworkGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Barry Hollywood.
 *
 * To test GraphFactory.
 */
public class GraphFactoryTest {
    private GraphFactory graphFactory;

    /**
     * Set up variables before each test.
     */
    @Before
    public void setUp(){
        graphFactory = new GraphFactory();
    }

    /**
     * Reset variables to null after each test.
     */
    @After
    public void tearDown(){
        graphFactory = null;
    }


    /**
     * Tests that GraphFactory's
     * getGraph() method is not null.
     */
    @Test
    public void testGetGraph(){
        boolean isGraph = false;
        Graph graph = graphFactory.getGraph("RailNetworkGraph");
        if(graph != null ){
            isGraph = true;
        }else{
            isGraph = false;
        }
        assertTrue( isGraph );
    }

    /**
     * Tests tha GraphFactory's
     * getGraphForRail() method
     * returns a RailNetworkGraph.
     */
    @Test
    public void testGetGraphForRail(){
        Graph graph = graphFactory.getGraph("RailNetworkGraph");
        assertTrue("Test failed: graph is not an instance of RailNetworkGraph...", graph instanceof RailNetworkGraph);
    }

    /**
     * Tests tha GraphFactory's
     * getGraphForRail() method
     * returns a RailNetworkGraph.
     */
    @Test
    public void testGetGraphForAir(){
        Graph graph = graphFactory.getGraph("AirNetworkGraph");
        assertTrue("Test failed: graph is not an instance of AirNetworkGraph...", graph instanceof AirNetworkGraph);
    }
}
