import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class LevelOrderUsingCount {

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int outerWhileCount = 0;
        int innerWhileCount = 0;

        while (!q.isEmpty()) {
            outerWhileCount++;

            int count = q.size();   // number of nodes at current level
            List<Integer> innerList = new ArrayList<>();

            while (count > 0) {
                innerWhileCount++;

                TreeNode node = q.poll();
                innerList.add(node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);

                count--;
            }

            ans.add(innerList);
        }

        // Printing loop counts
        System.out.println("Outer while loop ran: " + outerWhileCount + " times");
        System.out.println("Inner while loop ran: " + innerWhileCount + " times");

        return ans;
    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        List<List<Integer>> result = levelOrder(root);

        System.out.println("Level Order Traversal:");
        System.out.println(result);
    }
}