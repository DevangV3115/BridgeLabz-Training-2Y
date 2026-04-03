class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Tree {

    static void preOrderTraversal(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    static void inOrderTraversal(Node root) {
        if (root == null) return;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }
    static void postOrderTraversal(Node root) {
        if (root == null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }


    public static void main(String[] args) {

        Node root = new Node(10);

        // 1st level
        root.left = new Node(15);
        root.right = new Node(20);

        // 2nd level
        root.left.left = new Node(30);
        root.left.right = new Node(40);
        root.right.left = new Node(50);
        root.right.right = new Node(60);

        // 3rd level
        root.left.right.left = new Node(70);
        root.left.right.right = new Node(80);
        root.right.left.right = new Node(90);
        root.right.right.left = new Node(100);

        System.out.print("Preorder Traversal: ");
        preOrderTraversal(root);
        System.out.println();
        System.out.print("Inorder Traversal: ");
        inOrderTraversal(root);
        System.out.println();
        System.out.print("Postorder Traversal: ");
        postOrderTraversal(root);
        
    }
}