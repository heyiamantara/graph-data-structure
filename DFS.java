import java.util.*;

public class DFS {

    private int vertices;
    private List<List<Integer>> adjList;

    public DFS(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();

        for(int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void dfsUtil(int node, boolean[] visited) {

        visited[node] = true;
        System.out.println(node + " ");

        for(int neighbor : adjList.get(node)) {
            if(!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        dfsUtil(start, visited);
    }

      public static void main(String[] args) {
        DFS g = new DFS(5);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);

        System.out.print("DFS Traversal: ");
        g.dfs(0);
    }
}