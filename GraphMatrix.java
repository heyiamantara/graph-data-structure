public class GraphMatrix {  
// Public class named GraphMatrix.
// File name should be GraphMatrix.java

    static int[][] buildGraph(int vertices, int[][] edges) {  
    // static method -> can call directly without object.
    //
    // Return type:
    // int[][]  = 2D array (matrix)
    //
    // vertices = total number of nodes
    // edges    = list of connections
    //
    // Example:
    // vertices = 5
    // edges = { {0,1}, {0,2}, {1,3} }

        int[][] matrix = new int[vertices][vertices];  
        // Create adjacency matrix.
        //
        // Rows    = source nodes
        // Columns = destination nodes
        //
        // Initially all values are 0 by default.
        //
        // Example for 3 vertices:
        // 0 0 0
        // 0 0 0
        // 0 0 0
        //
        // Meaning:
        // No edges yet.

        for (int[] edge : edges) {  
        // Enhanced for loop.
        // Takes one edge at a time.
        //
        // Example:
        // edge = {0,1}

            int u = edge[0];  
            // First node of edge.

            int v = edge[1];  
            // Second node of edge.

            matrix[u][v] = 1;  
            // Mark connection from u to v.
            //
            // Means:
            // Node u is connected to node v

            matrix[v][u] = 1;  
            // Mark reverse connection.
            //
            // Needed because graph is UNDIRECTED.
            //
            // If graph were directed:
            // Remove this line.
        }

        return matrix;  
        // Return completed adjacency matrix.
    }

    static void printMatrix(int[][] matrix) {  
    // Method to print matrix neatly.
    //
    // matrix parameter receives graph matrix.

        System.out.println("Adjacency Matrix:");  
        // Heading

        for (int i = 0; i < matrix.length; i++) {  
        // Outer loop for rows.
        //
        // matrix.length = number of rows
        // = total vertices

            for (int j = 0; j < matrix[i].length; j++) {  
            // Inner loop for columns.
            //
            // matrix[i].length = columns in row i

                System.out.print(matrix[i][j] + " ");  
                // Print current cell value.
                //
                // 1 means edge exists
                // 0 means no edge
            }

            System.out.println();  
            // Move to next line after each row.
        }
    }

    public static void main(String[] args) {  
    // Main method.
    // Program starts here.

        int vertices = 5;  
        // Total nodes:
        // 0,1,2,3,4

        int[][] edges = {  
        // Store graph edges.

            {0,1},  
            // Edge between 0 and 1

            {0,2},  
            // Edge between 0 and 2

            {1,3},  
            // Edge between 1 and 3

            {2,4}   
            // Edge between 2 and 4
        };

        int[][] graph = buildGraph(vertices, edges);  
        // Build adjacency matrix graph.

        printMatrix(graph);  
        // Print final matrix.
    }
}