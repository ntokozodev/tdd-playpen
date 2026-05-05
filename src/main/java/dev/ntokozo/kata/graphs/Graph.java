package dev.ntokozo.kata.graphs;

import java.util.*;

public class Graph {
    private final Map<String, List<String>> adjacencyList = new HashMap<>();

    public void addEdge(String source, String destination) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.get(source).add(destination);

        // For undirected graphs (friends), add the reverse too
        adjacencyList.putIfAbsent(destination, new ArrayList<>());
        adjacencyList.get(destination).add(source);
    }

    public boolean hasPath(String start, String target) {
        if (start.equals(target))
            return true;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            // Get all neighbors of the current node
            List<String> neighbors = adjacencyList.getOrDefault(current, new ArrayList<>());
            for (String neighbor : neighbors) {
                if (neighbor.equals(target))
                    return true; // Found it!

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return false; // Looked everywhere, no path.
    }

    public Integer calculateShortestDistance(String start, String target) {
        if (start.equals(target))
            return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        int distance = 0;

        while (!queue.isEmpty()) {
            int nodeAtThisLevel = queue.size(); // Lock the current wave size
            distance++;

            for (int i = 0; i < nodeAtThisLevel; i++) {
                var current = queue.poll();
                var neighbors = adjacencyList.getOrDefault(current, new ArrayList<>());

                for (String neighbor : neighbors) {
                    if (neighbor.equals(target))
                        return distance; // Found in current wave!

                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        return -1; // Looked everywhere, no connection.
    }
}
