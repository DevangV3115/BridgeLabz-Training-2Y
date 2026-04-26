import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class TreeBFS {

    // Level Order Traversal (BFS)
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.val);

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }

        return result;
    }

    public static void main(String[] args) {

        // Constructing the tree from your image
        TreeNode root = new TreeNode(25);

        root.left = new TreeNode(10);
        root.right = new TreeNode(35);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);

        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(40);

        root.left.right.left = new TreeNode(13);
        root.left.right.right = new TreeNode(20);

        // Get traversal
        List<Integer> result = levelOrder(root);

        // Print output
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}