package bh.railcode.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Barry on 31/08/2014.
 *
 * To test FormatRoutesList.
 */
public class FormatRoutesListTest {

    private GraphFactory graphFactory;
    private FormatRoutesList formatRoutesList;

    /**
     * Set up variables before each test.
     */
    @Before
    public void setUp(){
        this.graphFactory = new GraphFactory();
        this.formatRoutesList = new FormatRoutesList();
    }

    /**
     * Reset variables to null after each test.
     */
    @After
    public void tearDown(){
        this.graphFactory = null;
        this.formatRoutesList = null;
    }

    /**
     * Test FormatRoutesList
     * formatRoutesList() method.
     */
    @Test
    public void testFormatRoutesList(){
        List<String> testRoutes = new ArrayList<String>();
        testRoutes.add("AABCE");
        testRoutes.add("AABBCCDDEE");
        testRoutes.add("ABCCDDE");

        List<String> expectedResults = new ArrayList<String>();
        expectedResults.add("ABCE");
        expectedResults.add("ABCDE");
        expectedResults.add("ABCDE");

        List<String> results = formatRoutesList.formatRoutesList(testRoutes);
        for(int i = 0; i < expectedResults.size(); i++){
            assertEquals("Test failed: Route not formatted correctly...", expectedResults.get(i), results.get(i));
        }
    }
}
