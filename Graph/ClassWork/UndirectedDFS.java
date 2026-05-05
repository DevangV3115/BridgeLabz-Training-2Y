import java.util.*;

public class UndirectedDFS {

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

        // Add undirected edges (both directions)

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);

        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);

        addEdge(adj, 2, 3);

        addEdge(adj, 4, 3);

        boolean[] visited = new boolean[V];

        System.out.print("DFS Traversal (Undirected) from 0: ");
        dfs(0, adj, visited);
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // important for undirected
    }
}