import java.util.*;

class Edge {
    String dest;
    int weight;

    Edge(String d, int w) {
        dest = d;
        weight = w;
    }
}

public class CityRoadNetwork {

    static Map<String, List<Edge>> graph = new HashMap<>();

    static void addEdge(String u, String v, int w, boolean bidirectional) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.get(u).add(new Edge(v, w));

        if (bidirectional) {
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(v).add(new Edge(u, w));
        }
    }

    // BFS reachable
    static void reachable(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            String curr = q.poll();
            System.out.print(curr + " ");

            for (Edge e : graph.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(e.dest)) {
                    visited.add(e.dest);
                    q.add(e.dest);
                }
            }
        }
    }

    // BFS shortest path (fewest edges)
    static void shortestPath(String start, String end) {
        Queue<String> q = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();
        Set<String> visited = new HashSet<>();

        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            String curr = q.poll();

            if (curr.equals(end)) break;

            for (Edge e : graph.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(e.dest)) {
                    visited.add(e.dest);
                    parent.put(e.dest, curr);
                    q.add(e.dest);
                }
            }
        }

        List<String> path = new ArrayList<>();
        String temp = end;
        while (temp != null) {
            path.add(temp);
            temp = parent.get(temp);
        }

        Collections.reverse(path);
        System.out.println("\nPath: " + path);
    }

    public static void main(String[] args) {

        addEdge("A", "B", 5, false);
        addEdge("B", "C", 3, true);
        addEdge("A", "D", 7, true);
        addEdge("D", "E", 2, false);
        addEdge("C", "E", 4, false);

        System.out.print("Reachable from A: ");
        reachable("A");

        shortestPath("A", "E");
    }
}