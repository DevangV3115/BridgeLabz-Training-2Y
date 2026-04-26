import java.util.*;

class ExpressionTreeEvaluation {

    static class Node {
        String data;
        Node left, right;

        Node(String data) {
            this.data = data;
        }
    }

    static void inorder(Node root) {
        if (root == null) return;
        System.out.print("(");
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
        System.out.print(")");
    }

    static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    static int evaluatePostfix(String[] expr) {
        Stack<Integer> st = new Stack<>();

        for (String s : expr) {
            if (Character.isDigit(s.charAt(0))) {
                st.push(Integer.parseInt(s));
            } else {
                int b = st.pop();
                int a = st.pop();

                switch (s) {
                    case "+": st.push(a + b); break;
                    case "-": st.push(a - b); break;
                    case "*": st.push(a * b); break;
                    case "/": st.push(a / b); break;
                }
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        // (3+5)*(8-2)
        Node root = new Node("*");
        root.left = new Node("+");
        root.right = new Node("-");

        root.left.left = new Node("3");
        root.left.right = new Node("5");

        root.right.left = new Node("8");
        root.right.right = new Node("2");

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        System.out.print("\nPreorder: ");
        preorder(root);

        System.out.print("\nPostorder: ");
        postorder(root);

        // evaluate
        String[] postfix = {"3","5","+","8","2","-","*"};
        System.out.println("\nResult: " + evaluatePostfix(postfix));
    }
}
