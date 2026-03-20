import java.util.*;
import java.util.Stack;
public class InfixToPostfix {

    // Function to return precedence of operators
    public static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return -1;
    }

    // Function to convert infix to postfix
    public static String infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // If operand → add to result
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }

            // If '(' → push to stack
            else if (ch == '(') {
                stack.push(ch);
            }

            // If ')' → pop until '('
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // remove '('
            }

            // If operator
            else {
                while (!stack.isEmpty() && 
                       precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter infix expression: ");
        String exp = sc.nextLine();

        String postfix = infixToPostfix(exp);

        System.out.println("Postfix expression: " + postfix);
    }
}