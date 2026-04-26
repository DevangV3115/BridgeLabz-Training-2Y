class TreeTerminologyIdentification {

    static class Node {
        String data;
        Node left, right;

        Node(String data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        // Construct tree
        Node CEO = new Node("CEO");
        CEO.left = new Node("CTO");
        CEO.right = new Node("CFO");

        CEO.left.left = new Node("Dev Lead");
        CEO.left.right = new Node("HR");

        CEO.left.left.left = new Node("Dev1");
        CEO.left.left.right = new Node("Dev2");

        // a) Leaf nodes
        System.out.print("Leaf Nodes: ");
        printLeaves(CEO);
        System.out.println();

        // b) Height
        System.out.println("Height of tree: " + height(CEO));

        // c) Depth of Dev Lead
        System.out.println("Depth of Dev Lead: " + depth(CEO, "Dev Lead", 0));

        // d) Ancestors of Dev1
        System.out.print("Ancestors of Dev1: ");
        printAncestors(CEO, "Dev1");
        System.out.println();

        // e) Degree of CTO
        Node CTO = CEO.left;
        int degree = (CTO.left != null ? 1 : 0) + (CTO.right != null ? 1 : 0);
        System.out.println("Degree of CTO: " + degree);
    }

    static void printLeaves(Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null)
            System.out.print(root.data + " ");
        printLeaves(root.left);
        printLeaves(root.right);
    }

    static int height(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static int depth(Node root, String key, int level) {
        if (root == null) return -1;
        if (root.data.equals(key)) return level;

        int left = depth(root.left, key, level + 1);
        if (left != -1) return left;

        return depth(root.right, key, level + 1);
    }

    static boolean printAncestors(Node root, String key) {
        if (root == null) return false;
        if (root.data.equals(key)) return true;

        if (printAncestors(root.left, key) || printAncestors(root.right, key)) {
            System.out.print(root.data + " ");
            return true;
        }
        return false;
    }
}

