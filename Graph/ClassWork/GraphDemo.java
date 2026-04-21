import java.util.*;

public class GraphDemo {
    int matrix[][];
    List<String> vertices;

    public GraphDemo() {
        matrix = new int[100][100];
        vertices = new ArrayList<>();
    }

    // Add vertex if not already present
    private void addVertex(String v) {
        if (!vertices.contains(v)) {
            vertices.add(v);
        }
    }

    // Add edge (undirected graph)
    public void addEdge(String v1, String v2) {
        addVertex(v1);
        addVertex(v2);

        int i = vertices.indexOf(v1);
        int j = vertices.indexOf(v2);

        matrix[i][j] = 1;
        matrix[j][i] = 1; // remove this line if graph is directed
    }

    // Print adjacency matrix
    public void printGraph() {
        System.out.print("  ");
        for (String v : vertices) {
            System.out.print(v + " ");
        }
        System.out.println();

        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i) + " ");
            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphDemo graphDemo = new GraphDemo();

        graphDemo.addEdge("A", "B");
        graphDemo.addEdge("A", "C");
        graphDemo.addEdge("B", "D");
        graphDemo.addEdge("C", "D");
        graphDemo.addEdge("D", "E");

        System.out.println("Graph:");
        graphDemo.printGraph();
    }
}