import java.util.*;

public class SocialNetwork {

    static Map<String, List<String>> graph = new HashMap<>();

    // Add friendship (undirected)
    static void addEdge(String u, String v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    // Find all friends
    static void getFriends(String user) {
        System.out.println("Friends of " + user + ": " + graph.get(user));
    }

    // Check direct connection
    static boolean isDirectFriend(String u, String v) {
        return graph.get(u).contains(v);
    }

    // BFS shortest path (degree of separation)
    static void shortestPath(String start, String end) {
        Queue<String> q = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();
        Set<String> visited = new HashSet<>();

        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            String curr = q.poll();

            if (curr.equals(end)) break;

            for (String nei : graph.get(curr)) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    parent.put(nei, curr);
                    q.add(nei);
                }
            }
        }

        // reconstruct path
        List<String> path = new ArrayList<>();
        String temp = end;
        while (temp != null) {
            path.add(temp);
            temp = parent.get(temp);
        }

        Collections.reverse(path);
        System.out.println("Shortest Path: " + path);
        System.out.println("Degree of Separation: " + (path.size() - 1));
    }

    public static void main(String[] args) {

        addEdge("Alice", "Bob");
        addEdge("Alice", "Charlie");
        addEdge("Bob", "David");
        addEdge("Charlie", "Eve");
        addEdge("David", "Eve");

        getFriends("Alice");

        System.out.println("Bob & Eve direct? " + isDirectFriend("Bob", "Eve"));

        shortestPath("Alice", "Eve");
    }
}