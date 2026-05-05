import java.util.*;

public class UndirectedBFS {

    public static void bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected edges
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);

        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);

        addEdge(adj, 2, 3);

        addEdge(adj, 4, 3);

        boolean[] visited = new boolean[V];

        System.out.print("BFS Traversal from 0: ");
        bfs(0, adj, visited);
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // undirected
    }
}