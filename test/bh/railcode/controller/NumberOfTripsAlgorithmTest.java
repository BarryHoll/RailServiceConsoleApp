package bh.railcode.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Barry Hollywood.
 *
 * Tests for NumberOfTripsAlgorithm.
 */
public class NumberOfTripsAlgorithmTest {

    private GraphFactory graphFactory;
    private NumberOfTripsAlgorithm numberOfTripsAlgorithm;

    /**
     * Set up variables before each test.
     */
    @Before
    public void setUp(){
        this.graphFactory = new GraphFactory();
        this. numberOfTripsAlgorithm = new NumberOfTripsAlgorithm(graphFactory.getGraph("RailNetworkGraph"));
    }

    /**
     * Reset variables to null after each test.
     */
    @After
    public void tearDown(){
        this.graphFactory = null;
        this.numberOfTripsAlgorithm = null;
    }

    /**
     * To test NumberOfTripsAlgorithm's
     * numberOfTripsMax() method.
     */
    @Test
    public void testNumberOfTripsMax(){
        int expectedResult = 2;
        int result = numberOfTripsAlgorithm.numberOfTripsMax("C", "C", 3);
        assertEquals("Test failed: Incorrect number of trips...", expectedResult, result);
    }

    /**
     * To test NumberOfTripsAlgorithm's
     * numberOfTripsExact() method.
     */
    @Test
    public void testNumberOfTripsExact(){
        int expectedResult = 3;
        int result = numberOfTripsAlgorithm.numberOfTripsExact("A", "C", 4);
        assertEquals("Test failed: Incorrect number of trips...", expectedResult, result);
    }
}
