import java.util.*;

public class GraphAdjList {
    public static void main(String[] args) {

        int V = 6; // number of vertices

        // Create adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // Initialize empty lists for all vertices
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (undirected graph)
        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(1).add(4);

        graph.get(2).add(0);
        graph.get(2).add(3);

        graph.get(3).add(2);
        graph.get(3).add(1);
        graph.get(3).add(4);

        graph.get(4).add(1);
        graph.get(4).add(3);

        // vertex 5 has no connections

        // Print adjacency list
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            System.out.println(graph.get(i));
        }
    }
}