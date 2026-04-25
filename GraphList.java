import java.util.*;  
// Import all utility classes from java.util package.
// Needed here for:
// List       -> interface for lists
// ArrayList  -> dynamic array implementation of List

public class GraphList {  
// Public class named GraphList.
// File name should be GraphList.java

    static List<List<Integer>> buildgraph(int vertices, int[][] edges) {  
    // static means method belongs to class itself.
    // Can call directly using:
    // buildgraph(...)
    //
    // Return type:
    // List<List<Integer>>
    //
    // Outer List = stores all vertices
    // Inner List = stores neighbors of each vertex
    //
    // vertices = total number of nodes
    // edges = connections between nodes

        List<List<Integer>> graph = new ArrayList<>();  
        // Create outer list.
        //
        // Example after full creation:
        // [
        //   [neighbors of 0],
        //   [neighbors of 1],
        //   [neighbors of 2],
        //   ...
        // ]

        for (int i = 0; i < vertices; i++) {  
        // Run loop from 0 to vertices - 1
        // Creates one empty list for every node.
        //
        // If vertices = 5
        // i = 0,1,2,3,4

            graph.add(new ArrayList<>());  
            // Add empty neighbor list for node i.
            //
            // After i=0:
            // [ [] ]
            //
            // After i=1:
            // [ [], [] ]
        }

        for (int[] edge : edges) {  
        // Enhanced for loop.
        // Takes one edge at a time from edges array.
        //
        // Example:
        // edge = {0,1}

            int u = edge[0];  
            // First value of edge.
            // Starting vertex.

            int v = edge[1];  
            // Second value of edge.
            // Connected vertex.

            graph.get(u).add(v);  
            // Add v to u's list.
            //
            // Means:
            // u is connected to v

            graph.get(v).add(u);  
            // Add u to v's list.
            //
            // Because graph is UNDIRECTED.
            // If directed graph, remove this line.
        }

        return graph;  
        // Return completed adjacency list.
    }

    public static void main(String[] args) {  
    // Main method.
    // Java starts execution from here.

        int vertices = 5;  
        // Total number of nodes.
        //
        // Nodes are:
        // 0,1,2,3,4

        int[][] edges = {  
        // 2D array storing all edges.

            {0,1},  
            // Edge between node 0 and node 1

            {0,2},  
            // Edge between node 0 and node 2

            {1,3},  
            // Edge between node 1 and node 3

            {2,4}   
            // Edge between node 2 and node 4
        };

        List<List<Integer>> graph = buildgraph(vertices, edges);  
        // Call method to create graph.
        //
        // Result:
        // 0 -> [1,2]
        // 1 -> [0,3]
        // 2 -> [0,4]
        // 3 -> [1]
        // 4 -> [2]

        System.out.println("Adjacency List:");  
        // Print heading.

        for (int i = 0; i < graph.size(); i++) {  
        // Loop through every node.
        //
        // graph.size() = total vertices

            System.out.println(i + " -> " + graph.get(i));  
            // Print node number and its neighbors.
            //
            // Example:
            // 0 -> [1, 2]
        }
    }
}