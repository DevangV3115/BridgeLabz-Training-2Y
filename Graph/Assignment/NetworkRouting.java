import java.util.*;

public class NetworkRouting {

    static Map<String, List<String>> graph = new HashMap<>();

    static void addEdge(String u, String v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());

        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    // Check connected (BFS)
    static boolean isConnected() {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        String start = graph.keySet().iterator().next();
        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            String curr = q.poll();

            for (String nei : graph.get(curr)) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    q.add(nei);
                }
            }
        }

        return visited.size() == graph.size();
    }

    // BFS min hops
    static void minHops(String start, String end) {
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> dist = new HashMap<>();

        q.add(start);
        dist.put(start, 0);

        while (!q.isEmpty()) {
            String curr = q.poll();

            for (String nei : graph.get(curr)) {
                if (!dist.containsKey(nei)) {
                    dist.put(nei, dist.get(curr) + 1);
                    q.add(nei);
                }
            }
        }

        System.out.println("Minimum Hops: " + dist.get(end));
    }

    public static void main(String[] args) {

        addEdge("R1", "R2");
        addEdge("R1", "R3");
        addEdge("R2", "R4");
        addEdge("R3", "R4");
        addEdge("R4", "R5");
        addEdge("R5", "R6");

        System.out.println("Network Connected? " + isConnected());

        minHops("R1", "R6");
    }
}