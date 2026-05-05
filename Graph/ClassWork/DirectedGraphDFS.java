import java.util.*;

public class DirectedGraphDFS {
    
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Edges
        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(3);
        adj.get(1).add(4);

        adj.get(2).add(3);

        adj.get(4).add(3);

        boolean[] visited = new boolean[V];

        System.out.print("DFS Traversal starting from 0: ");
        dfs(0, adj, visited);
    }
}