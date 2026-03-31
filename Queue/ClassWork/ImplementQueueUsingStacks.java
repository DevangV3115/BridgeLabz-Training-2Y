import java.util.Stack;

public class ImplementQueueUsingStacks {

    private Stack<Integer> input;
    private Stack<Integer> output;

    // Constructor
    public ImplementQueueUsingStacks() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    // Push element to back of queue
    public void push(int x) {
        input.push(x);
    }
    
    // Remove element from front
    public int pop() {
        peek(); // ensure output has elements
        return output.pop();
    }
    
    // Get front element
    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    // Check if queue is empty
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    // Main method for testing
    public static void main(String[] args) {
        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();

        queue.push(1);
        queue.push(2);

        System.out.println("Peek: " + queue.peek()); // 1
        System.out.println("Pop: " + queue.pop());   // 1
        System.out.println("Empty: " + queue.empty()); // false
    }
}