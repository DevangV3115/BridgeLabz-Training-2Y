class TreeNode {
    char data;
    TreeNode left, right;

    TreeNode(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeExample {

    // Create the tree
    public static TreeNode createTree() {

        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        TreeNode I = new TreeNode('I');
        TreeNode J = new TreeNode('J');
        TreeNode K = new TreeNode('K');

        // Connections
        A.left = B;
        A.right = C;

        B.left = D;
        B.right = E;

        C.left = G;
        C.right = H;

        E.left = I;
        E.right = J;

        G.right = K;

        return A; // root
    }

    // Inorder Traversal
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Preorder Traversal
    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Traversal
    public static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        TreeNode root = createTree();

        System.out.print("Inorder: ");
        inorder(root);

        System.out.print("\nPreorder: ");
        preorder(root);

        System.out.print("\nPostorder: ");
        postorder(root);
    }
}