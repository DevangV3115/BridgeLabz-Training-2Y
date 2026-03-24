import java.util.*;
import java.util.Stack;
class BrowserHistory {
    Stack<String> backStack = new Stack<>();
    Stack<String> forwardStack = new Stack<>();

    // Constructor
    BrowserHistory(String homepage) {
        backStack.push(homepage);
    }

    // Visit a new URL
    void visit(String url) {
        while (!forwardStack.isEmpty()) {
            forwardStack.pop();
        }
        backStack.push(url);
    }

    // Move back
    String back(int steps) {
        while (backStack.size() > 1 && steps-- > 0) {
            forwardStack.push(backStack.peek());
            backStack.pop();
        }
        return backStack.peek();
    }

    // Move forward
    String forward(int steps) {
        while (!forwardStack.isEmpty() && steps-- > 0) {
            backStack.push(forwardStack.peek());
            forwardStack.pop();
        }
        return backStack.peek();
    }
}

public class BrowserHistoryMain {
    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory("google.com");

        bh.visit("youtube.com");
        bh.visit("facebook.com");
        bh.visit("linkedin.com");

        System.out.println("Back 1: " + bh.back(1));   // facebook
        System.out.println("Back 1: " + bh.back(1));   // youtube
        System.out.println("Forward 1: " + bh.forward(1)); // facebook

        bh.visit("twitter.com");

        System.out.println("Forward 2: " + bh.forward(2)); // twitter (no forward)
        System.out.println("Back 2: " + bh.back(2));   // youtube
        System.out.println("Back 7: " + bh.back(7));   // google
    }
}