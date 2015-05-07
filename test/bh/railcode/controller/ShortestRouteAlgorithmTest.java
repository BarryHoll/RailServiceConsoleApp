package bh.railcode.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Barry Hollywood.
 *
 * Tests for ShortestRouteAlgorithm.
 */
public class ShortestRouteAlgorithmTest {

    private GraphFactory graphFactory;
    private ShortestRouteAlgorithm shortestRouteAlgorithm;

    /**
     * Set up variables before each test.
     */
    @Before
    public void setUp(){
        this.graphFactory = new GraphFactory();
        this.shortestRouteAlgorithm = new ShortestRouteAlgorithm(graphFactory.getGraph("RailNetworkGraph"));
    }

    /**
     * Reset variables to null after each test.
     */
    @After
    public void tearDown(){
        this.graphFactory = null;
        this.shortestRouteAlgorithm = null;
    }


    /**
     * To test ShortestRouteAlgorithm's
     * lengthOfShortestRouteMethod.
     */
    @Test
    public void testLengthOfShortestRoute() {
        int expectedResult = 9;
        int result = shortestRouteAlgorithm.lengthOfShortestRoute("A", "C", 8);
        assertEquals("Test failed: Incorrect shortest route length...", expectedResult, result);
    }

}
