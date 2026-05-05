import java.util.*;

public class DirectedBFS {

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

        // Directed edges (ONLY one direction)
        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(3);
        adj.get(1).add(4);

        adj.get(2).add(3);

        adj.get(4).add(3);

        boolean[] visited = new boolean[V];

        System.out.print("BFS Traversal (Directed) from 0: ");
        bfs(0, adj, visited);
    }
}