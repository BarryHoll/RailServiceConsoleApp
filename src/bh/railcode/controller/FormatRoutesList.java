package bh.railcode.controller;

import bh.railcode.model.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Barry Hollywood.
 *
 * Class to remove repeated letters in routes which are
 * part of a list of routes. For example route string 'AABBCC'
 * would be formatted as 'ABC'.
 */
public class FormatRoutesList {
    /**
     * The purpose of this method is to ensure all
     * routes in routeList are correctly formatted
     * before calculating the route distance.
     */
    public static List<String> formatRoutesList(List<String> routeList){
        List<String> newRouteList = new ArrayList<String>();
        String formattedRoute;
        for (String route : routeList){
            formattedRoute = replaceLetters(route);
            newRouteList.add(formattedRoute);
        }
        routeList = newRouteList;
        return routeList;
    }

    /**
     * The purpose of this method is to return a route
     * string with no double letters in it.
     * @param route - correctly formatted route.
     * @return
     */
    private static String replaceLetters(String route){
        String replacedString = route.replaceAll("AA", "A");
        String replacedString2 = replacedString.replaceAll("BB", "B");
        String replacedString3 = replacedString2.replaceAll("CC", "C");
        String replacedString4 = replacedString3.replaceAll("DD", "D");
        String replacedString5 = replacedString4.replaceAll("EE", "E");
        return replacedString5.replaceAll("AA", "A");
    }
}
