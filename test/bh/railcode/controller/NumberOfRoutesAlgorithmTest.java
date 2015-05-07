package bh.railcode.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Barry Hollywood.
 *
 * Tests for NumberOfRoutesAlgorithm.
 */
public class NumberOfRoutesAlgorithmTest {

    private GraphFactory graphFactory;
    private NumberOfRoutesAlgorithm numberOfRoutesAlgorithm;

    /**
     * Set up variables before each test.
     */
    @Before
    public void setUp(){
        this.graphFactory = new GraphFactory();
        this.numberOfRoutesAlgorithm = new NumberOfRoutesAlgorithm(graphFactory.getGraph("RailNetworkGraph"));
    }

    /**
     * Reset variables to null after each test.
     */
    @After
    public void tearDown(){
        this.graphFactory = null;
        this.numberOfRoutesAlgorithm = null;
    }

    /**
     * To test NumberOfRoutesAlgorithm
     * numberOfRoutesMax() method.
     */
    @Test
    public void testNumberOfRoutesMax(){
        int expectedResult = 7;
        int result = numberOfRoutesAlgorithm.numberOfRoutesMax("C", "C", 30, 10);
        assertEquals("Test failed: Incorrect number of routes...", expectedResult, result);
    }
}
