package bh.railcode.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Barry Hollywood.
 *
 * To test DistanceAlgorithm.
 */
public class DistanceAlgorithmTest {

    private GraphFactory graphFactory;
    private DistanceAlgorithm distanceAlgorithm;

    /**
     * Set up variables before each test.
     */
    @Before
    public void setUp(){
        this.graphFactory = new GraphFactory();
        this.distanceAlgorithm = new DistanceAlgorithm(graphFactory.getGraph("RailNetworkGraph"));
    }

    /**
     * Reset variables to null after each test.
     */
    @After
    public void tearDown(){
        this.graphFactory = null;
        this.distanceAlgorithm = null;
    }

    /**
     * Test DistanceAlgorithm's
     * calculateRouteDistance() method.
     */
    @Test
    public void testCalculateRouteDistance() {
        String expectedResult = "9";
        String result = distanceAlgorithm.calculateRouteDistance("ABC");
        assertEquals("Test failed: Route distance not as expected...", expectedResult, result);
    }
}
