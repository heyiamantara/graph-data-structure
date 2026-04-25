import java.util.*;  
// Import utility classes from java.util package.
// Needed for:
// List       -> stores adjacency list
// ArrayList  -> dynamic array implementation
// Arrays     -> helps insert multiple values quickly

public class DFSGraph {

    static void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        // Recursive DFS method.
        //
        // graph   = adjacency list of graph
        // visited = tracks already visited nodes
        // node    = current node being explored

        visited[node] = true;
        // Mark current node as visited.
        // This prevents revisiting same node again.

        System.out.print(node + " ");
        // Process current node.
        // Here processing means printing.

        for (int neighbor : graph.get(node)) {
            // Get all neighbors of current node.
            //
            // Example:
            // graph.get(0) = [1,2]

            if (!visited[neighbor]) {
                // If neighbor not visited:

                dfs(graph, visited, neighbor);
                // Recursively visit that neighbor.
                //
                // DFS goes DEEP first before trying others.
            }
        }

        // When all neighbors finished,
        // function returns automatically (backtracking).
    }

    public static void main(String[] args) {

        List<List<Integer>> graph = new ArrayList<>();
        // Create adjacency list.

        for (int i = 0; i < 5; i++) {
            graph.add(new ArrayList<>());
        }
        // Create 5 empty lists for nodes 0 to 4.

        graph.get(0).addAll(Arrays.asList(1, 2));
        // Node 0 connected to 1 and 2

        graph.get(1).addAll(Arrays.asList(0, 3));
        // Node 1 connected to 0 and 3

        graph.get(2).addAll(Arrays.asList(0, 4));
        // Node 2 connected to 0 and 4

        graph.get(3).add(1);
        // Node 3 connected to 1

        graph.get(4).add(2);
        // Node 4 connected to 2

        /*
            Graph Structure:

                  0
                 / \
                1   2
                |   |
                3   4
        */

        boolean[] visited = new boolean[graph.size()];
        // Initially:
        // [false,false,false,false,false]

        System.out.print("DFS Traversal: ");

        dfs(graph, visited, 0);
        // Start DFS from node 0

        System.out.println();
    }
}

/*

Time Complexity: O(V + E)

V = Number of vertices
E = Number of edges

Why?
- Each vertex is visited once.
- Each edge is checked once (or twice in undirected graph).


Space Complexity: O(V)

Why?
- visited[] array uses O(V)
- Recursive call stack can go up to O(V)
  in worst case (chain graph)

*/