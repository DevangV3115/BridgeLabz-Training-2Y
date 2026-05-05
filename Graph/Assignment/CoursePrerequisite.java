import java.util.*;

public class CoursePrerequisite {

    static Map<String, List<String>> graph = new HashMap<>();

    static void addEdge(String u, String v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.get(u).add(v);
    }

    // Cycle Detection (DFS)
    static boolean hasCycle() {
        Set<String> visited = new HashSet<>();
        Set<String> recStack = new HashSet<>();

        for (String node : graph.keySet()) {
            if (dfsCycle(node, visited, recStack)) return true;
        }
        return false;
    }

    static boolean dfsCycle(String node, Set<String> visited, Set<String> recStack) {
        if (recStack.contains(node)) return true;
        if (visited.contains(node)) return false;

        visited.add(node);
        recStack.add(node);

        for (String nei : graph.getOrDefault(node, new ArrayList<>())) {
            if (dfsCycle(nei, visited, recStack)) return true;
        }

        recStack.remove(node);
        return false;
    }

    // Find prerequisites using DFS
    static void findPrerequisites(String course) {
        Set<String> visited = new HashSet<>();
        dfs(course, visited);
        visited.remove(course);
        System.out.println("Prerequisites: " + visited);
    }

    static void dfs(String node, Set<String> visited) {
        if (visited.contains(node)) return;
        visited.add(node);

        for (String nei : graph.getOrDefault(node, new ArrayList<>())) {
            dfs(nei, visited);
        }
    }

    // Topological Sort (Kahn's Algorithm)
    static void topoSort() {
        Map<String, Integer> indegree = new HashMap<>();

        for (String node : graph.keySet()) {
            indegree.putIfAbsent(node, 0);
            for (String nei : graph.get(node)) {
                indegree.put(nei, indegree.getOrDefault(nei, 0) + 1);
            }
        }

        Queue<String> q = new LinkedList<>();

        for (String node : indegree.keySet()) {
            if (indegree.get(node) == 0) q.add(node);
        }

        List<String> order = new ArrayList<>();

        while (!q.isEmpty()) {
            String curr = q.poll();
            order.add(curr);

            for (String nei : graph.getOrDefault(curr, new ArrayList<>())) {
                indegree.put(nei, indegree.get(nei) - 1);
                if (indegree.get(nei) == 0) q.add(nei);
            }
        }

        System.out.println("Course Order: " + order);
    }

    public static void main(String[] args) {

        addEdge("CS101", "CS102");
        addEdge("CS101", "CS201");
        addEdge("CS102", "CS202");
        addEdge("MATH101", "CS201");

        System.out.println("Has Cycle? " + hasCycle());

        findPrerequisites("CS202");

        topoSort();
    }
}