package dev.ntokozo.kata.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    @Test
    void hasPath_givenDirectConnection_shouldReturnTrue() {
        var graph = new Graph();
        graph.addEdge("Ntokozo", "Java");

        assertTrue(graph.hasPath("Ntokozo", "Java"));
    }

    @Test
    void hasPath_givenIndirectConnection_shouldReturnTrue() {
        var graph = new Graph();
        graph.addEdge("Ntokozo", "eThekwini");
        graph.addEdge("eThekwini", "eJozi");

        assertTrue(graph.hasPath("Ntokozo", "eJozi"));
    }

    @Test
    void hasPath_givenDisconnectedNodes_shouldReturnFalse() {
        var graph = new Graph();
        graph.addEdge("Ntokozo", "Java");
        graph.addEdge("Ntokozo", "eThekwini");

        assertFalse(graph.hasPath("Ntokozo", "Python"));
    }

    @Test
    void calculateShortestDistance_givenSameNode_shouldReturnZero() {
        var graph = new Graph();
        var expected = 0;
        var result = graph.calculateShortestDistance("Ntokozo", "Ntokozo");

        assertEquals(expected, result);
    }

    @Test
    void calculateShortestDistance_givenDirectFriends_shouldReturnOne() {
        var graph = new Graph();
        graph.addEdge("Ntokozo", "Mjey");
        var expected = 1;
        var result = graph.calculateShortestDistance("Ntokozo", "Mjey");

        assertEquals(expected, result);
    }

    @Test
    void calculateShortestDistance_givenIndirectFriends_shouldReturnCorrectDistance() {
        var graph = new Graph();
        graph.addEdge("Ntokozo", "Mjey");
        graph.addEdge("Mjey", "Allan");
        var expected = 2;
        var result = graph.calculateShortestDistance("Ntokozo", "Allan");

        assertEquals(expected, result);
    }

    @Test
    void calculateShortestDistance_givenMultiplePaths_shouldReturnShortest() {
        // Path 1: A -> B -> C (2 steps)
        // Path 2: A -> D -> E -> C (3 steps)
        var graph = new Graph();
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("A", "D");
        graph.addEdge("D", "E");
        graph.addEdge("E", "C");

        var expected = 2;
        var result = graph.calculateShortestDistance("A", "C");
        
        assertEquals(expected, result);
    }

    @Test
    void calculateShortestDistance_givenNoConnection_shouldReturnNegativeOne() {
        var graph = new Graph();
        graph.addEdge("Ntokozo", "Java");
        graph.addEdge("Python", "DataScience");
        var expected = -1;
        var result = graph.calculateShortestDistance("Ntokozo", "Python");
        
        assertEquals(expected, result);
    }
}
