package dev.ntokozo.kata.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    @Test
    public void givenDirectConnection_shouldReturnTrue() {
        var graph = new Graph();
        graph.addEdge("Ntokozo", "Java");

        assertTrue(graph.hasPath("Ntokozo", "Java"));
    }

    @Test
    public void givenIndirectConnection_shouldReturnTrue() {
        var graph = new Graph();
        graph.addEdge("Ntokozo", "eThekwini");
        graph.addEdge("eThekwini", "eJozi");

        assertTrue(graph.hasPath("Ntokozo", "eJozi"));
    }

    @Test
    public void givenDisconnectedNodes_shouldReturnFalse() {
        // Ntokozo is not connected to "Python"
        var graph = new Graph();
        graph.addEdge("Ntokozo", "Java");
        graph.addEdge("Ntokozo", "eThekwini");

        assertFalse(graph.hasPath("Ntokozo", "Python"));
    }
}
