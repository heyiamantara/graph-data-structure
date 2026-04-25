import java.util.*;  
// Import all utility classes from java.util package.
// Needed for:
// List        -> stores adjacency list
// ArrayList   -> dynamic array
// Queue       -> interface for FIFO structure
// LinkedList  -> used to implement Queue

public class BFSGraph {  
// Public class named BFSGraph.
// Save file as BFSGraph.java

    static void bfs(List<List<Integer>> graph, int start) {  
    // static method -> can call directly without object.
    //
    // Return type = void
    // Means method performs action but returns nothing.
    //
    // graph = adjacency list representation of graph
    // start = node where BFS begins

        boolean[] visited = new boolean[graph.size()];  
        // Create boolean array to track visited nodes.
        //
        // graph.size() = total number of vertices.
        //
        // Initially all values are false by default:
        // [false, false, false, false, false]
        //
        // Why needed?
        // Prevents revisiting same node again and again.
        // Avoids infinite loop in cyclic graphs.

        Queue<Integer> queue = new LinkedList<>();  
        // Create queue for BFS.
        //
        // BFS always uses Queue (FIFO):
        // First In First Out
        //
        // Node inserted first is processed first.

        visited[start] = true;  
        // Mark starting node as visited.
        //
        // Important:
        // We mark BEFORE adding to queue.
        // This prevents duplicate insertions later.

        queue.offer(start);  
        // Add starting node into queue.
        //
        // Example if start = 0:
        // Queue = [0]

        System.out.print("BFS Traversal: ");  
        // Heading for output.

        while (!queue.isEmpty()) {  
        // Continue loop while queue has nodes.
        //
        // Stops when all reachable nodes processed.

            int node = queue.poll();  
            // Remove front node from queue.
            //
            // poll() removes and returns front item.
            //
            // Example:
            // Queue before = [0,1,2]
            // node = 0
            // Queue after = [1,2]

            System.out.print(node + " ");  
            // Process current node.
            // Here processing means printing it.
            //
            // In real problems:
            // Could count distance, search target, etc.

            for (int neighbor : graph.get(node)) {  
            // Traverse all neighbors of current node.
            //
            // graph.get(node) gives adjacency list.
            //
            // Example:
            // graph.get(0) = [1,2]

                if (!visited[neighbor]) {  
                // If neighbor not visited yet.

                    visited[neighbor] = true;  
                    // Mark neighbor visited immediately.
                    //
                    // Important:
                    // Mark now, not later.
                    // Prevents duplicate queue entries.

                    queue.offer(neighbor);  
                    // Add neighbor to queue.
                    //
                    // It will be processed later.
                    //
                    // Since queue is FIFO,
                    // all current level nodes process first.
                }
            }
        }

        System.out.println();  
        // Move cursor to next line after traversal ends.
    }

    public static void main(String[] args) {  
    // Program execution starts here.

        List<List<Integer>> graph = new ArrayList<>();  
        // Create adjacency list graph.

        for (int i = 0; i < 5; i++) {  
        // Create 5 empty lists for nodes 0 to 4.

            graph.add(new ArrayList<>());
        }

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

        // Final graph:
        //
        //      0
        //     / \
        //    1   2
        //    |   |
        //    3   4

        bfs(graph, 0);  
        // Start BFS from node 0.
    }
}

 /*
        Breadth First Search (BFS)

        Time Complexity:
        O(V + E)

        V = Number of vertices
        E = Number of edges

        Why?
        - Each vertex enters queue once.
        - Each edge is checked once (or twice in undirected graph).

        Space Complexity:
        O(V)

        Why?
        - visited[] array stores V values
        - queue can store up to V nodes
    */