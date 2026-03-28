import java.util.*;

public class BFS {

    private int vertices;
    private List<List<Integer>> adjList;
 
    public BFS(int v) {
        vertices = v;
        adjList = new ArrayList<>();

        for(int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    } 

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node);

            for(int neighbor : adjList.get(node))  {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS g = new BFS(5);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);

        System.out.print("BFS Traversal: ");
        g.bfs(0);
    }
}