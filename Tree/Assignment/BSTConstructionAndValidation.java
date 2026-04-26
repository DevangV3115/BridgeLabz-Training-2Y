class BSTConstructionAndValidation {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.data) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static boolean isBST(Node root, int min, int max) {
        if (root == null) return true;
        if (root.data <= min || root.data >= max) return false;

        return isBST(root.left, min, root.data) &&
               isBST(root.right, root.data, max);
    }

    public static void main(String[] args) {
        int[] arr = {50,30,70,20,40,60,80,10,25};
        Node root = null;

        for (int x : arr)
            root = insert(root, x);

        System.out.print("Inorder (Sorted): ");
        inorder(root);
        System.out.println();

        System.out.println("Is BST valid: " + isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
