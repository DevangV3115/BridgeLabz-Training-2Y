import java.util.*;

public class DirectedGraph {
    public static void main(String[] args) {
        int V = 5; // number of vertices (0 to 4)

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize lists
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(3);
        adj.get(1).add(4);

        adj.get(2).add(3);

        // 3 has no outgoing edges

        adj.get(4).add(3);

        // Print adjacency list
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int node : adj.get(i)) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}