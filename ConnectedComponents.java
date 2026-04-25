import java.util.*;  
// Import utility classes.
// Needed for:
// List       -> stores graph
// ArrayList  -> dynamic list

class Solution {

    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        // Method returns total number of connected components.
        //
        // V = number of vertices (0 to V-1)
        // edges = list of edges
        //
        // Example:
        // edges = [[0,1], [1,2], [3,4]]

        List<List<Integer>> adj = new ArrayList<>();
        // Create adjacency list graph.

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Create V empty lists.
        //
        // If V = 5:
        // [
        //  [],
        //  [],
        //  [],
        //  [],
        //  []
        // ]

        for (List<Integer> edge : edges) {
            // Read one edge at a time.

            int u = edge.get(0);
            // First node of edge.

            int v = edge.get(1);
            // Second node of edge.

            adj.get(u).add(v);
            // Add v into u's neighbor list.

            adj.get(v).add(u);
            // Add u into v's neighbor list.
            //
            // Because graph is undirected.
        }

        boolean[] visited = new boolean[V];
        // visited[i] = true means node i already explored.
        //
        // Initially all false.

        int components = 0;
        // Stores number of connected components.

        for (int i = 0; i < V; i++) {
            // Visit every node one by one.

            if (!visited[i]) {
                // If current node not visited,
                // it means new component found.

                components++;
                // Increase component count.

                dfs(i, adj, visited);
                // Visit all nodes connected to i.
                //
                // Entire component gets marked visited.
            }
        }

        return components;
        // Return total connected components.
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        // Standard DFS traversal.

        visited[node] = true;
        // Mark current node visited.

        for (int neighbor : adj.get(node)) {
            // Traverse all adjacent nodes.

            if (!visited[neighbor]) {
                // If neighbor not visited:

                dfs(neighbor, adj, visited);
                // Recursively visit neighbor.
            }
        }
    }
}

/*

Example:

V = 5
edges = [[0,1], [1,2], [3,4]]

Graph:

0 --- 1 --- 2

3 --- 4

Traversal:

i = 0 -> unvisited
components = 1
DFS visits 0,1,2

i = 1 visited skip
i = 2 visited skip

i = 3 unvisited
components = 2
DFS visits 3,4

Final Answer = 2


Time Complexity: O(V + E)

Why?
- Every vertex visited once.
- Every edge checked once (or twice undirected).


Space Complexity: O(V)

Why?
- visited[] uses O(V)
- recursion stack worst case O(V)

*/