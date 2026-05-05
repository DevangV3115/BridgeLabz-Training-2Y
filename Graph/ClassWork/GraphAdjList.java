import java.util.*;

public class GraphAdjList {

    // BFS Traversal
    public static void bfs(int start, ArrayList<ArrayList<Integer>> graph, int V) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // DFS Traversal (Recursive)
    public static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, graph);
            }
        }
    }

    public static void main(String[] args) {

        int V = 6;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
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

        // Print adjacency list
        for (int i = 0; i < V; i++) {
            System.out.println(i + " -> " + graph.get(i));
        }

        // Run BFS from node 0
        bfs(0, graph, V);

        // Run DFS from node 0
        boolean[] visited = new boolean[V];
        System.out.print("DFS: ");
        dfs(0, visited, graph);
    }
}